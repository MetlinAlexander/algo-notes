class Node {
    int value;
    int key;
    Node prev;
    Node next;

    Node() {
    }
}

class LRUCache {

    int capacity;
    Node start = new Node();
    Node end = new Node();
    HashMap<Integer, Node> values;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        start.next = end;
        end.prev = start;
        values = new HashMap<>();
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        // find [prev]->[cur]->[next]
        Node cur = values.get(key);
        updateNodeCache(cur);

        return cur.value;
    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            Node cur = values.get(key);
            updateNodeCache(cur);
            cur.value = value;
            return;
        }
        if (values.size() == capacity) {
            Node cur = end.prev;
            Node prev = cur.prev;
            Node next = cur.next;
            // delete cur [prev]->[next]
            prev.next = next;
            next.prev = prev;
            values.remove(cur.key);
        }
        Node cur = new Node();
        cur.value = value;
        cur.key = key;
        //insert at the start cur
        cur.next = start.next;
        start.next.prev = cur;

        cur.prev = start;
        start.next = cur;

        values.put(key, cur);
    }

    public void updateNodeCache(Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        // delete cur [prev]->[next]
        prev.next = next;
        next.prev = prev;
        //insert at the start cur
        cur.next = start.next;
        start.next.prev = cur;

        cur.prev = start;
        start.next = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */