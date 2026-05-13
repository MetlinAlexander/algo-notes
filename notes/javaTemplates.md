# shpora

# 🧠 Java Cheat Sheet (Algo Interview)

---

## 📦 HashMap

Map<K, V> map = new HashMap<>();

**Основные методы:**

- map.put(key, value)
- map.get(key)
- map.getOrDefault(key, defaultVal)
- map.containsKey(key)
- map.remove(key)
- map.size()
- map.isEmpty()

**Итерация:**

- for (K key : map.keySet())
- for (V value : map.values())
- for (Map.Entry<K, V> e : map.entrySet())

**Важно:**

- O(1) average
- не потокобезопасен
- 1 null ключ допустим

---

## 🌳 TreeMap

TreeMap<K, V> map = new TreeMap<>();

**Методы:**

- map.put(key, value)
- map.get(key)
- map.firstKey()
- map.lastKey()
- map.floorKey(key)
- map.ceilingKey(key)
- map.subMap(a, b)

**Важно:**

- O(log n)
- отсортирован (Red-Black Tree)

---

## 🔵 HashSet

Set<T> set = new HashSet<>();

**Методы:**

- set.add(x)
- set.remove(x)
- set.contains(x)
- set.size()

**Важно:**

- уникальные элементы
- внутри HashMap

---

## 🌲 TreeSet

TreeSet<T> set = new TreeSet<>();

**Методы:**

- set.add(x)
- set.remove(x)
- set.first()
- set.last()
- set.floor(x)
- set.ceiling(x)

**Важно:**

- отсортирован
- O(log n)

---

## 📚 ArrayList

List<T> list = new ArrayList<>();

**Методы:**

- list.add(x)
- list.add(index, x)
- list.get(i)
- list.set(i, x)
- list.remove(i)
- list.size()

**Важно:**

- доступ O(1)
- вставка O(n)

---

## 🔗 LinkedList

LinkedList<T> list = new LinkedList<>();

**Методы:**

- list.add(x)
- list.addFirst(x)
- list.addLast(x)
- list.removeFirst()
- list.removeLast()
- list.get(i)

**Важно:**

- вставка O(1)
- доступ O(n)

---

## 📏 Массив (Array)

int[] arr = new int[n];

**Операции:**

- arr[i]
- arr[i] = x
- arr.length

**Важно:**

- фиксированный размер
- O(1) доступ

---

## 🔤 String

String s = "abc";

**Методы:**

- s.length()
- s.charAt(i)
- s.substring(l, r)
- s.contains("a")
- s.indexOf("a")
- s.equals(other)
- s.compareTo(other)
- s.toCharArray()
- s.split(" ")

**Важно:**

- immutable
- конкатенация O(n)

---

## 🔡 Работа с символами

char c = 'a';

**Методы:**

- Character.isDigit(c)
- Character.isLetter(c)
- Character.isLetterOrDigit(c)
- Character.toLowerCase(c)
- Character.toUpperCase(c)

**Фишки:**

- c - 'a' // индекс буквы
- 'a' + i // обратно в char

---

## 🔄 StringBuilder

StringBuilder sb = new StringBuilder();

**Методы:**

- sb.append(x)
- sb.insert(i, x)
- sb.delete(l, r)
- sb.reverse()
- sb.toString()

**Важно:**

- mutable
- быстрее String при конкатенации

---

## 📥📤 Ввод / вывод

**BufferedReader (быстро):**

- BufferedReader br = new BufferedReader(new InputStreamReader([System.in](http://system.in/)))
- String line = br.readLine()
- String[] parts = line.split(" ")
- int x = Integer.parseInt(parts[0])

**Scanner (проще):**

- Scanner sc = new Scanner([System.in](http://system.in/))
- int x = sc.nextInt()
- String s = sc.next()

**Вывод:**

- System.out.println(x)
- System.out.print(x)

---

## ⚡ Утилиты

- Arrays.sort(arr)
- Arrays.fill(arr, val)
- Arrays.equals(a, b)
- Collections.sort(list)
- Collections.reverse(list)
- Collections.max(list)
- Collections.min(list)

---

## 🧠 Частые ловушки

- map.get(key) == null → не всегда значит, что ключа нет
- list.remove(1) → удаляет по индексу
- "abc" == new String("abc") → false