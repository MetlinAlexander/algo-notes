from pathlib import Path
import re
import sys


ROOT = Path(__file__).resolve().parents[1]
PLATFORM = "leetcode"
LANGUAGE = "java"
LANGUAGE_LABEL = "Java"
DIFFICULTIES = ("easy", "medium", "hard")
SOLUTION_FILE = "Solution.java"
NOTES_FILE = "notes.md"


def title_from_folder(folder_name: str) -> str:
    match = re.match(r"^(\d{4})-(.+)$", folder_name)
    if not match:
        return folder_name

    problem_id, slug = match.groups()
    title = slug.replace("-", " ")
    return f"{problem_id}. {title}"


def repo_path(path: Path) -> str:
    return path.relative_to(ROOT).as_posix()


def build_rows() -> tuple[list[dict[str, str]], list[str]]:
    rows = []
    errors = []
    java_root = ROOT / PLATFORM / LANGUAGE

    for difficulty in DIFFICULTIES:
        difficulty_dir = java_root / difficulty
        if not difficulty_dir.exists():
            continue

        for problem_dir in sorted(difficulty_dir.iterdir(), key=lambda path: path.name):
            if not problem_dir.is_dir():
                continue

            solution_path = problem_dir / SOLUTION_FILE
            notes_path = problem_dir / NOTES_FILE

            if not solution_path.exists():
                errors.append(f"Missing {SOLUTION_FILE}: {repo_path(problem_dir)}")
            if not notes_path.exists():
                errors.append(f"Missing {NOTES_FILE}: {repo_path(problem_dir)}")

            rows.append(
                {
                    "platform": PLATFORM,
                    "difficulty": difficulty,
                    "problem": title_from_folder(problem_dir.name),
                    "language": LANGUAGE_LABEL,
                    "solution": (
                        f"[{SOLUTION_FILE}]({repo_path(solution_path)})"
                        if solution_path.exists()
                        else "-"
                    ),
                    "notes": (
                        f"[{NOTES_FILE}]({repo_path(notes_path)})"
                        if notes_path.exists()
                        else "-"
                    ),
                }
            )

    return rows, errors


def render_progress(rows: list[dict[str, str]]) -> str:
    lines = [
        "# Progress",
        "",
        "| Platform | Difficulty | Problem | Language | Solution | Notes |",
        "|---|---|---|---|---|---|",
    ]

    for row in rows:
        lines.append(
            f"| {row['platform']} | {row['difficulty']} | {row['problem']} | "
            f"{row['language']} | {row['solution']} | {row['notes']} |"
        )

    lines.append("")
    return "\n".join(lines)


def main() -> int:
    rows, errors = build_rows()
    (ROOT / "PROGRESS.md").write_text(render_progress(rows), encoding="utf-8")

    if errors:
        print("Repository structure errors:")
        for error in errors:
            print(f"- {error}")
        return 1

    return 0


if __name__ == "__main__":
    sys.exit(main())
