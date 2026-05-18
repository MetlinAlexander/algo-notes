# 1493. Longest Subarray of 1's After Deleting One Element

## link
LeetCode: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

## Pattern
- Sliding window

## Idea
### Rus
По условию надо найти максимальный подмассив из 1, после удаления одного элемента. Стоит заметить что лучше удалять именно 0, так как это сделает ответ большим. Будем идти скользящим окном по массиву и учитывать, чтоб в один момент был всегда один 0 в окне.
В ответе главное учесть, что если массив только из единиц, то удалить все же стоит 1 элемент и выдать в ответ на 1 меньше.
### Eng
According to the condition, you need to find the maximum subarray of 1 after removing one element. It is worth noting that it is better to remove the 0, as this will make the answer larger. You will move a sliding window through the array and ensure that there is always one 0 in the window at any given moment.
In the answer, it is important to consider that if the array consists only of 1s, it is still worth removing 1 element and returning 1 less in the answer.

## Complexity
- Time: O(n)
- Space: O(1)

## Problems
если нулей нет, то выводим на 1 меньше ответ.
