package priv.cxs.classic150;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
            if (size > capacity) {
                cache.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                size--;
            }
        }
    }
}
