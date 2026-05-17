# [1446 - Consecutive Characters]

## link
LeetCode: https://leetcode.com/problems/consecutive-characters/

## Pattern
- Strings

## Idea
### Rus
Задание не требует применения специальных алгоритмов. Нужно аккуратно пройтись по всей строке и посчитать максильную подстроку повторяющихся симвовлов. Храним текущий, который инциализируем 1 симоволом. Идем с 1 индекса и сравниваем `i and i-1`. 
### Eng
The task does not require the use of special algorithms. You need to carefully traverse the entire string and calculate the maximum substring of repeating characters. We store the current character, which is initialized to 1. We start from index 1 and compare `i and i-1`.

## Complexity
- Time: O(n)
- Space: O(1)

## Problems
