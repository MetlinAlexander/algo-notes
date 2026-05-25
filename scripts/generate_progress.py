from pathlib import Path
import re
import sys

ROOT = Path(__file__).resolve().parents[1]

PLATFORMS = ["leetcode"]
DIFFICULTIES = ["easy", "medium", "hard"]

LANGUAGE_NAMES = {
    "java": "Java",
    "python": "Python",
    "cpp": "C++",
}

SOLUTION_FILES = {
    "java": "Solution.java",
    "python": "solution.py",
    "cpp": "solution.cpp",
}


def parse_problem_name(folder_name: str):
    match = re.match(r"^(\d+)[-_](.+)$", folder_name)

    if not match:
        return None, folder_name.replace("-", " ")

    problem_id = match.group(1)
    title = match.group(2).replace("-", " ").replace("_", " ")

    return int(problem_id), f"{problem_id}. {title}"


def path_link(path: Path) -> str:
    return path.relative_to(ROOT).as_posix()


def main():
    rows = []
    errors = []

    for platform in PLATFORMS:
        platform_dir = ROOT / platform

        if not platform_dir.exists():
            continue

        for lang_dir in platform_dir.iterdir():
            if not lang_dir.is_dir():
                continue

            lang = lang_dir.name
            lang_name = LANGUAGE_NAMES.get(lang, lang)

            for difficulty in DIFFICULTIES:
                difficulty_dir = lang_dir / difficulty

                if not difficulty_dir.exists():
                    continue

                for problem_dir in sorted(difficulty_dir.iterdir()):
                    if not problem_dir.is_dir():
                        continue

                    problem_id, problem_title = parse_problem_name(problem_dir.name)

                    expected_solution = SOLUTION_FILES.get(lang)
                    solution_path = problem_dir / expected_solution if expected_solution else None
                    notes_path = problem_dir / "notes.md"

                    if expected_solution and not solution_path.exists():
                        errors.append(
                            f"Missing {expected_solution}: {path_link(problem_dir)}"
                        )

                    if not notes_path.exists():
                        errors.append(
                            f"Missing notes.md: {path_link(problem_dir)}"
                        )

                    solution_cell = (
                        f"[{expected_solution}]({path_link(solution_path)})"
                        if solution_path and solution_path.exists()
                        else "—"
                    )

                    notes_cell = (
                        f"[notes.md]({path_link(notes_path)})"
                        if notes_path.exists()
                        else "—"
                    )

                    rows.append({
                        "platform": platform.capitalize(),
                        "difficulty": difficulty.capitalize(),
                        "problem": problem_title,
                        "language": lang_name,
                        "solution": solution_cell,
                        "notes": notes_cell,
                        "sort_id": problem_id if problem_id is not None else 10**9,
                    })

    rows.sort(key=lambda row: (row["platform"], row["language"], row["difficulty"], row["sort_id"], row["problem"]))

    progress = []
    progress.append("# Progress")
    progress.append("")
    progress.append(f"Total solved: **{len(rows)}**")
    progress.append("")
    progress.append("| Platform | Difficulty | Problem | Language | Solution | Notes |")
    progress.append("|---|---|---|---|---|---|")

    for row in rows:
        progress.append(
            f"| {row['platform']} | {row['difficulty']} | {row['problem']} | "
            f"{row['language']} | {row['solution']} | {row['notes']} |"
        )

    progress.append("")

    (ROOT / "PROGRESS.md").write_text("\n".join(progress), encoding="utf-8")

    if errors:
        print("Repository structure errors:")
        for error in errors:
            print(f"- {error}")
        sys.exit(1)


if __name__ == "__main__":
    main()