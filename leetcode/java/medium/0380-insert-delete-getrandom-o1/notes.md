# 380. Insert Delete GetRandom O(1)

## link
LeetCode: https://leetcode.com/problems/insert-delete-getrandom-o1/

## Pattern
- Array
- HashMap

## Idea
### Rus
Необычная задача относительно других. Здесь необходимо сделать реализацию структуры данных.
Чтоб получить констатный вставку и удаление, можно использовать просто `HashSet`. Но главная проблема это получить рандомный константный доступ к элементу. Так как из HashSet или HashMap нельзя напрямую получить рандомный элемент за констаное время.
Поэтому идея хранить элементы одновременно в массиве и в HashMap. Массив будет просто по порядку их хранить. При добавлении в конец ставим, при удалении убираем элемент и на его место ставим последний элемент массива. При доступе просто выбираем рандомный индекс и получаем его.
А вот HashMap будет хранить в ключах значения. А в значениях индекс в массиве где они. Это нужно чтоб можно было легко проверять есть элемент или нет. И удалять также быстро не проходясь по всему массиву.
Для того чтоб понимать где конец массива, можно использовать длину HashMap. Она будет значит сколько элементов сейчас у нас.
### Eng
An unusual task relative to others. Here it is necessary to implement the data structure.
To get the correct insertion and deletion, you can simply use a `HashSet'. But the main problem is to get random constant access to the element. Since you cannot directly get a random element from a HashSet or HashMap in a given time.
Therefore, the idea is to store the elements simultaneously in an array and in a HashMap. The array will simply store them in order. When adding to the end, we put, when deleting, we remove the element and put the last element of the array in its place. When accessing, we simply select a random index and get it.
But HashMap will store the values in the keys. And in the values, the index in the array is where they are. This is necessary so that you can easily check whether there is an element or not. And delete it quickly, too, without going through the entire array.
In order to understand where the end of the array is, you can use the HashMap length. It will mean how many elements we have now.

## Complexity
- Time: O(1)
- Space: O(n)

## Problems
