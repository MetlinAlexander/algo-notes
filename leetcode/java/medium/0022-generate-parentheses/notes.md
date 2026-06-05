# 22. Generate Parentheses

## link
LeetCode: https://leetcode.com/problems/generate-parentheses/

## Pattern
- String
- Backtracking

## Idea
### Rus
Нужно сгенерировать все корректные комбинации из n пар круглых скобок. Корректность означает, что в любом префиксе строки количество закрывающих скобок не превышает количество открывающих, и в итоге их поровну.
Используем рекурсивный backtracking. На каждом шаге буфер размера `2*n` и два счетчика: сколько открывающих скобок уже поставили (opened) и сколько закрывающих (closed). Рекурсия заканчивается, когда сумма opened + closed достигла 2*n — тогда буфер полностью заполнен, и мы добавляем его в ответ.

В рекурсии делаем два хода:
Если opened < n, можно добавить '(' — это всегда безопасно.
Если closed < opened, можно добавить ')' — это гарантирует, что закрывающих не станет больше, чем открывающих в любом префиксе.

Благодаря этому условию все сгенерированные строки будут корректными. Ответ собирается в список строк.

### Eng
We need to generate all valid combinations of n pairs of parentheses. Validity means that in any prefix of the string, the number of closing parentheses never exceeds the number of opening ones, and at the end they are equal.
We use recursive backtracking. At each step, we have a buffer of size `2*n` and two counters: how many opening parentheses have been placed (opened) and how many closing ones (closed). The recursion terminates when opened + closed == 2*n — the buffer is full, and we add it to the answer.

In the recursion, we make two possible moves:
If opened < n, we can add '(' — this is always safe.
If closed < opened, we can add ')' — this ensures that closing parentheses never exceed opening ones in any prefix.

This condition guarantees that all generated strings are valid. The answer is collected in a list of strings.

## Complexity
- Time: O(2^(2*n))
- Space: O(n)

## Problems
