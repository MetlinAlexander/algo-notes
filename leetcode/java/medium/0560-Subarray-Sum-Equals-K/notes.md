# 560. Subarray Sum Equals K

## link
LeetCode: https://leetcode.com/problems/subarray-sum-equals-k/

## Pattern
- HashMap
- prefix sum

## Idea
### Rus
Нужно найти число ненулевых подмасивов, сумма элементов которого будет равна данному числу. В данном случае не получиться использовать sliding window или two pointers, так как в массиве есть отрицательные числа, которые не будут учтены тогда. 
Используем следующий подход. Заведем хеш мапу, в которой будем хранить сколько было отрезков с данной суммой до этого. Далее идем по массиву и считаем текущую его сумму. 
Далее нам надо понять, насколько текущая сумма отличается от той, которую нам надо достигунть.
Это можно вычислить так `sum - k` так получим, какой отрезок до нам надо отрезать, чтоб сумма подмассива стала равной данной. Из хешмапы получаем сколько таких было до нас и плюсуем ее к ответ.
Также для учета ситуации когда текущая сумма уже равно данной нам. Мы можем либо отдельно писать if с првоверкой. Либо же сложить в самом начале в хешпаму по ключу `{0 : 1}`. Так можно будет учитвать это без отдельной проверки
### Eng
We need to find the number of non-zero subarrays whose sum is equal to a given number. In this case, we cannot use a sliding window or two pointers, as there are negative numbers in the array that would not be considered. 
We can use the following approach. We will create a hash map to store the number of subarrays with a given sum. We will iterate through the array and calculate the current sum. 
Next, we need to determine how much the current sum differs from the desired sum.
This can be calculated as follows: `sum - k` will give us the length of the subarray that needs to be removed to make the sum equal to the given value. From the hashmap, we can get the number of subarrays that have already been removed and add it to the answer.
Additionally, we need to consider the case where the current sum is already equal to the given value. In this case, we can either write an if statement with a check. Alternatively, we can add the value to the hashmap at the beginning using the key `{0 : 1}`. This will allow us to account for this situation without requiring an additional check.

## Complexity
- Time: O(n)
- Space: O(n)

## Problems
