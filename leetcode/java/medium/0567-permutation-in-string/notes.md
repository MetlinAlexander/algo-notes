# 567. Permutation in String

## link
LeetCode: https://leetcode.com/problems/permutation-in-string/

## Pattern
- HashMap
- Sliding window

## Idea
### Rus
Нужно проверить, содержит ли строка s2 перестановку строки s1 в качестве подстроки. То есть существует ли окно в s2 длины len(s1), в котором частоты всех символов совпадают с частотами в s1.

Используем скользящее окно (sliding window) фиксированного размера = длине s1. Два хешмапа: h1 для частот символов в s1 и h2 для частот символов в текущем окне s2.

Сначала заполняем h1 для s1 и инициализируем h2 для первого окна в s2 (первые len(s1) символов). Затем считаем количество совпадающих символов (matches) — тех, чья частота в h2 равна частоте в h1.

Далее двигаем окно: на каждом шаге удаляем левый символ (c1) и добавляем правый символ (c2). Перед удалением/добавлением проверяем, был ли символ в "совпадении" (matches), и корректируем счетчик. После обновления окна проверяем, равно ли matches размеру h1 (т.е. все символы совпадают по частоте). Если да — возвращаем true.

В конце, если окно не нашлось, возвращаем false.
### Eng
We need to check whether string s2 contains a permutation of string s1 as a substring. That is, whether there exists a window of length len(s1) in s2 where the frequencies of all characters match those in s1.

We use a sliding window of fixed size = length of s1. Two hashmaps: h1 for character frequencies in s1, and h2 for character frequencies in the current window in s2.

First, we populate h1 from s1 and initialize h2 from the first window in s2 (first len(s1) characters). Then we count the number of matching characters (matches) — those whose frequency in h2 equals the frequency in h1.

Then we slide the window: at each step, we remove the left character (c1) and add the right character (c2). Before removal/addition, we check if the character was in "match" and adjust the counter accordingly. After updating the window, we check if matches equals the size of h1 (i.e., all characters match in frequency). If yes — return true.

At the end, if no such window is found, return false.

## Complexity
- Time: O(n)
- Space: O(n)

## Problems
