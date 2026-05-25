# 443. String Compression

## link
LeetCode: https://leetcode.com/problems/string-compression/

## Pattern
- two pointers
- String

## Idea
### Rus
Нам сказано, что нужно не использовать доп память, то есть ответ засунуть в текущий массив, также вернуть длину занятого места. Для этого вводим одну переменную, которая будет хранить ответ и также будет указателем на место, куда записываем текущий ответ.
Проходимся обычным for-циклом по массиву. В начале запоминиаем старт текущий, с которого будем искать конец промежутка. Дальше проходимся внутренним циклом while до того момента как вообще существует следующий элемент и пока он равен предыдущему.
После сразу вписываем по месту указателя ответа текущую букву.
Дальше считаем сколько было букв в этом промежутке.
Если больше одной, то по порядку записываем в текущий массив число посимвольн, не забыв увеличить указатель.
### Eng
We are told that we do not need to use additional memory, so we put the answer in the current array and return the length of the occupied space. To do this, we introduce a variable that will store the answer and also act as a pointer to the location where we will store the current answer.
We use a regular for-loop to traverse the array. At the beginning, we remember the current start point from which we will search for the end of the interval. Then, we use an inner while loop until the next element exists and is equal to the previous one.
After that, we immediately enter the current letter in the place of the response pointer.
Next, we count how many letters were in this interval.
If there are more than one, we write the number of characters in the current array in order, remembering to increase the pointer.

## Complexity
- Time: O(n)
- Space: O(1)

## Problems
