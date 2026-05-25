# 228. Summary Ranges

## link
LeetCode: https://leetcode.com/problems/summary-ranges/

## Pattern
- String
- Array

## Idea
### Rus
Можно пойти таким путем. Проходимся обычным for-циклом по массиву. В начале запоминиаем старт текущий, с которого будем искать конец промежутка. Дальше проходимся внутренним циклом while до того момента как вообще существует следующие число и пока оно больше на 1.
Далее мы проверяем состоит ли данный промежуток из одного числа или нескольких. В зависимости от этого мы делаем либо само число. либо конец и начало через черточку.
Самое главное в задаче не усложнять решением краевыми случаями.
### Eng
You can go this way. We go through the usual for-loop through the array. At the beginning, we remember the current start, from which we will look for the end of the interval. Then, we go through the inner while loop until the next number exists and it is greater than 1.
Next, we check whether the interval consists of a single number or several numbers. Depending on this, we either do the number itself. or the end and the beginning through a dash.
The most important thing in the task is not to complicate the solution with edge cases.

## Complexity
- Time: O(n)
- Space: O(n)

## Problems
