# 23. Merge k Sorted Lists

## link
LeetCode: https://leetcode.com/problems/merge-k-sorted-lists/

## Pattern

* Linked List
* Divide and Conquer
* Merge Sort

## Idea
### Rus
Требуется объединить `k` отсортированных связных списков в один отсортированный список.

Наивный подход — последовательно мержить каждый список с результатом предыдущих объединений. Однако в этом случае один и тот же узел может участвовать в слиянии много раз, что приводит к сложности около `O(N * k)`.

Вместо этого используется подход **Divide and Conquer**, аналогичный Merge Sort.

Сначала объединяются соседние списки попарно:

```text
L1 + L2
L3 + L4
L5 + L6
...
```

После первого прохода количество списков уменьшается примерно вдвое.

Затем объединяются уже полученные результаты:

```text
(L1+L2) + (L3+L4)
(L5+L6) + (L7+L8)
...
```

Размер объединяемых групп удваивается на каждой итерации. Для этого используется переменная `interval`:

```text
interval = 1
interval = 2
interval = 4
interval = 8
...
```

На каждом шаге выполняется:

```java
lists[i] = merge(lists[i], lists[i + interval]);
```

Пока `interval` не станет больше количества списков.

Для объединения двух отсортированных списков используется стандартный алгоритм с dummy-узлом и двумя указателями.

В результате каждый уровень обработки проходит по всем узлам один раз, а количество уровней равно `log(k)`.

### Eng

We need to merge `k` sorted linked lists into a single sorted list.

A naive approach is to merge the lists one by one into a growing result. However, this causes the same nodes to be processed multiple times, resulting in roughly `O(N * k)` complexity.

Instead, we use a **Divide and Conquer** strategy similar to Merge Sort.

First, we merge adjacent pairs of lists:

```text
L1 + L2
L3 + L4
L5 + L6
...
```

After the first pass, the number of lists is reduced by approximately half.

Then we merge the merged results:

```text
(L1+L2) + (L3+L4)
(L5+L6) + (L7+L8)
...
```

The size of merged groups doubles after every iteration. This is controlled by the `interval` variable:

```text
interval = 1
interval = 2
interval = 4
interval = 8
...
```

At each step we perform:

```java
lists[i] = merge(lists[i], lists[i + interval]);
```

until `interval` becomes greater than or equal to the number of lists.

The helper `merge()` function merges two sorted linked lists using the standard dummy-node technique.

Since each level processes all nodes once and there are `log(k)` levels, the overall complexity is `O(N log k)`.

## Complexity

- Time: `O(N log k)`
- Space: `O(1)`

where:

* `N` = total number of nodes across all lists
* `k` = number of linked lists

## Problems

* Easy to forget the loop condition:

```java
i + interval < lists.length
```

otherwise an index out of bounds error may occur.

* Be careful not to create new nodes during merge. The solution should reuse existing nodes by updating `next` pointers.

* The final answer is stored in:

```java
lists[0]
```

after all merge rounds are completed.
