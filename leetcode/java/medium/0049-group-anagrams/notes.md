# 443. String Compression

## link
LeetCode: https://leetcode.com/problems/string-compression/

## Pattern
- String
- Sort
- HashMap

## Idea
### Rus
По условию надо сгруппировать анаграмы строк. 
Сделаем отдельный метод для сортировки строки, в котором преобразуем ее в массив и сортируем. 
Далее сделаем хешмапу в которой ключом будет сортированная строка. А значением массив строк.
Так вот идем по строкам. Сначала ее сортируем и ищем. Есть ли такой ключ в хешмапе. Если нет, то создаем массив. Дальше просто кладем текущую строку по этому ключу.
В конце проходимся по хешмапе и перекладываем все массивы в переменную с ответом.
### Eng
By condition, it is necessary to group the anagrams of the strings. 
Let's make a separate method for sorting a string, in which we convert it into an array and sort it. 
Next, we will make a hashmap in which the key will be a sorted string. And the value is an array of strings.
So here we go along the lines. First, we sort it and search for it. Is there such a key in the hashmap? If not, then create an array. Then we just put the current line on this key.
At the end, we go through the hashmap and transfer all the arrays to the response variable.

## Complexity
- Time: O(n)
- Space: O(n*s*log(s))

## Problems
