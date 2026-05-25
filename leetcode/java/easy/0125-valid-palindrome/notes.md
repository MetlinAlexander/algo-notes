# 125. Valid Palindrome

## link
LeetCode: https://leetcode.com/problems/valid-palindrome/

## Pattern
- Strings
- two pointers

## Idea
### Rus
По заданию надо проверить, что строка является палиндромом. Приэтом игнорируя все не численно-буквенные символы. И проводя сравнение не учитывая регистр. 
Используем два указателя. Один на конец, другой на начало. Идем пока они не пересекутся друг с другом. Сначала пропускаем все символы, что не являются буквой или цифровой. Дальше приводом оба символа по текущим указателям в нижний регистр и сравнивание равны ли они. Если нет, то просто возвращаем сразу false. 
Если мы вышли из цикла, значит строка палиндром и возвращаем true.
### Eng
The task is to check if a string is a palindrome. We ignore all non-numeric and non-alphabetic characters. We compare the characters without considering their case.
We use two pointers. One points to the end of the string, and the other points to the beginning. We move the pointers until they meet. We skip all characters that are not letters or numbers. We convert both characters at the current pointers to lowercase and compare them to see if they are equal. If they are not equal, we return false immediately. 
If we exit the loop, then the string is a palindrome, and we return true.

## Complexity
- Time: O(n)
- Space: O(1)

## Problems
Полезно помни методы строк и символов.
`Characters.toLowerCase();`
`Characters.isLetterOrDigit();`
