# 146. LRU Cache

## link
LeetCode: https://leetcode.com/problems/lru-cache/

## Pattern
- HashMap
- Linked list

## Idea
### Rus
Нужно сделать структуру данных, куда можно класть и брать элементы по ключу за O(1). При этом также она
обладает `capacity`. И если нужно положить новый элемент, но места нет уже. То нужно удалить тот, который раньше всего по времени взаимодействовали в последний раз. 
Для этого будем хранить двусвязнный линкед лист. И мапу.
Если длина мапы превыщает `capacity`. То удаляем последний элемент в линкед листе. Если взаимодействием с элементом, то отправляем его в начала линкед листа.
### Eng
We need to create a data structure where we can put and take elements by key in O(1). At the same time, it also
has `capacity`. And if you need to put a new element, but there is no more space. Then you need to delete the one that was most recently interacted with. 
To do this, we will store a doubly linked linked list. And the map.
If the map length exceeds the `capacity'. Then we delete the last element in the linked list. If you interact with an element, send it to the beginning of the linked sheet.

## Complexity
- Time: get=O(1), put=O(1)
- Space: O(n)

## Problems
