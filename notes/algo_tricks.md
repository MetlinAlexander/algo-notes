# Полезные алгоритмические паттерны и наблюдения

---

# 1. Barrier / Padding Pattern

## Идея

Если есть задача на обход матрицы или сетки, иногда удобно
добавить вокруг неё "барьер" (padding / border).

Это позволяет:
- убрать проверки выхода за границы;
- упростить код;
- сделать логику переходов одинаковой для всех клеток.

---

## Вместо

```java
if (nx >= 0 && nx < n && ny >= 0 && ny < m)
```

---

## Можно сделать

```text
#######
#.....#
#.....#
#.....#
#######
```

и спокойно ходить по соседям.

---

## Где полезно

- BFS / DFS
- лабиринты
- flood fill
- задачи на острова
- симуляции
- game of life

---

# 2. Fast & Slow Pointers (Floyd Cycle Detection)

## Идея

Используем:
- slow pointer → двигается на 1
- fast pointer → двигается на 2

Если они встретились → есть цикл.

---

## Где используется

- Linked List Cycle
- Happy Number
- поиск середины списка
- поиск цикла в функциональном графе

---

## Шаблон

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true;
    }
}
```

---

# 3. Direction Array / Shift Array

## Идея

Для обхода соседей в матрице удобно хранить массив сдвигов.

---

## Вместо

```java
up
down
left
right
```

---

## Используем

```java
int[] dx = {-1, 1, 0, 0};
int[] dy = {0, 0, -1, 1};
```

---

## Обход

```java
for (int d = 0; d < 4; d++) {
    int nx = x + dx[d];
    int ny = y + dy[d];
}
```

---

## Диагонали

```java
int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
```

---

# 4. Binary Search Patterns

## Основная идея

Бинарный поиск = поиск границы.

Не "ищем элемент", а:
- первый подходящий;
- последний подходящий;
- минимальный valid;
- максимальный invalid.

---

## Полезное наблюдение

Бинарный поиск удобно проверять на ситуации,
когда остаётся только 2 элемента.

Это помогает:
- избежать infinite loop;
- правильно выбрать mid;
- понять движение границ.

---

## Хороший бинарный поиск

Обычно содержит только:

```java
if (...) {
} else {
}
```

Без лишних special cases.

---

# Left Binary Search

## Ищем

```text
min i : x <= arr[i]
```

---

```cpp
// left binary search | min i : (x <= arr[i])

LLint leftBinSearch(
    LLint l,
    LLint r,
    std::vector<LLint> &arr,
    LLint x
) {
    LLint m;

    while (l < r) {

        m = (l + r) / 2;

        if (x <= arr[m]) {
            r = m;
        } else {
            l = m + 1;
        }
    }

    return l;
}
```

---

# Right Binary Search

## Ищем

```text
max i : x >= arr[i]
```

---

```cpp
// right binary search | max i : (x >= arr[i])

LLint rightBinarySearch(
    LLint l,
    LLint r,
    std::vector<LLint> &arr,
    LLint x
) {
    LLint m;

    while (l < r) {

        m = (l + r + 1) / 2;

        if (x >= arr[m]) {
            l = m;
        } else {
            r = m - 1;
        }
    }

    return l;
}
```

---

## Почему +1 в mid справа

```cpp
m = (l + r + 1) / 2;
```

Иначе при двух элементах:

```text
l = 5
r = 6
m = 5
```

граница может не двигаться → infinite loop.

---

# 5. Group Expansion Pattern

## Идея

Используется в задачах, где нужно обрабатывать подряд идущие элементы,
образующие одну группу.

---

## Алгоритм

1. Запоминаем начало группы
2. Расширяем указатель, пока следующий элемент подходит
3. После while имеем готовый сегмент `[start..end]`

---

## Шаблон

```java
for (int i = 0; i < n; i++) {

    int start = i;

    while (i + 1 < n && condition(i, i + 1)) {
        i++;
    }

    int end = i;

    // обработка группы
}
```

---

## Что это даёт

- O(n)
- каждый элемент посещается один раз
- нет отдельной обработки последней группы
- удобно для строк, массивов и интервалов

---

## Где встречается

### Одинаковые элементы

```java
chars[i] == chars[i + 1]
```

Примеры:
- String Compression
- Remove Duplicates

---

### Непрерывный диапазон

```java
nums[i] + 1 == nums[i + 1]
```

Примеры:
- Summary Ranges

---

## Ключевая идея

```text
consume maximal valid segment
```

То есть:
- поглощаем максимально длинный валидный сегмент;
- после while имеем полностью готовую группу.

---

## Отличие от Sliding Window

Тут окно:
- только расширяется;
- не сжимается;
- группы не пересекаются.

Это скорее:

```text
partition into maximal segments
```

чем полноценный sliding window.