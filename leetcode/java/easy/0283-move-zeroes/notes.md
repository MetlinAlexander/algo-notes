# 1. Two sum

## link
LeetCode: https://leetcode.com/problems/move-zeroes/

## Pattern
- two pointers

## Idea
### Rus
Нужно сдвинуть все нули в конце. Приэтом без доп памяти. Будем использовать два указателя.
Одним идем по массиву. А другой `lastNonZero` будет указывать на то место, куда можно сдвинуть не нулевой элемент.
Дальше если в массиве мы встречаем не нулевой элемент, то сдвигаем его по указателю `lastNonZero` и увеличиваем его на 1 `lastNonZero++`.
В конце проходимся еще раз по массиву начинаю с `lastNonZero` и зануляем все значения. Так как все ненулевые значения мы сдвинули уже до него.
### Eng
We need to shift all the zeros at the end. Without using additional memory. We will use two pointers.
One pointer will traverse the array. The other pointer, `lastNonZero`, will point to the location where the non-zero element can be shifted.
If we encounter a non-zero element in the array, we will shift it using the `lastNonZero` pointer and increment it by 1 using `lastNonZero++`.
At the end, we go through the array again, starting with `lastNonZero`, and set all the values to zero. Since we have already shifted all the non-zero values before it.

## Complexity
- Time: O(n)
- Space: O(1)

## Problems
