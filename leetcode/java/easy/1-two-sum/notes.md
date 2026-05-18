# 1. Two sum

## link
LeetCode: https://leetcode.com/problems/two-sum

## Pattern
- HashMap

## Idea
### Rus
По заданию требуется найти два индекса чисел, которые в сумме дадут target. Будем хранить те числа, что уже прошли. Для этого используем HashMap для O(1) доступа по значению и хранения индекса на котором было это число. Далее идем по всему массиву и проверяем было ли уже в HashMap такое значение, которые бы в сумме с текущим дало target. Если дает, то возвращаем индексы. Иначе кладем в HashMap это значению по ключу, а по значению его индекс.
### Eng
The task is to find two indices of numbers that add up to target. We will store the numbers that have already been passed. To do this, we use a HashMap for O(1) access by value and store the index where the number was found. Then, we iterate through the array and check if the HashMap already contains a value that adds up to target. If it does, we return the indices. Otherwise, we add the value to the HashMap using the key and its index using the value.

## Complexity
- Time: O(n)
- Space: O(n)

## Problems
