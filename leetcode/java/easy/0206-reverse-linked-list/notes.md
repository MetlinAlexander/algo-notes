# 206. Reverse Linked List

## link
LeetCode: https://leetcode.com/problems/reverse-linked-list

## Pattern
- linked list

## Idea
### Rus
Нужно развернуть связанный список. Сделаем это за один проход по нему. Будем хранить текущий элемент и предыдущий, который инициализируем null. Идем по циклу по текущий элемент не null. В цикле запоминаем наш следующий элемент. И переставляем дальше у текушего элемента ссылку на предыдущий. После чего сдвигаем предыдуший на голову. А голову на следующий за ним.
Вернуть нужно будет именно предыдущий, так как голову мы дойдем до null.
### Eng
You need to expand the linked list. We'll do it in one pass through it. We will store the current element and the previous one, which we initialize to null. We go through the loop by the current element is not null. In the loop, we memorize our next element. And then we move the link to the previous one from the flowing element. After that, we move the previous one on its head. And head to the next one after him.
It will be necessary to return the previous one, since we will reach the null head.

## Complexity
- Time: O(n)
- Space: O(1)

## Problems
