package com.thealgorithms.datastructures.hashmap.hashing;

public class HashMap<K, V> {
    private final int hashSize;
    private final LinkedList<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMap(int hashSize) {
        this.hashSize = hashSize;
        
        this.buckets = new LinkedList[hashSize];
        for (int i = 0; i < hashSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int computeHash(K key) {
        if (key == null) {
            return 0; 
        }
        int hash = key.hashCode() % hashSize;
        return hash < 0 ? hash + hashSize : hash;
    }

    public void insert(K key, V value) {
        int hash = computeHash(key);
        buckets[hash].insert(key, value);
    }

    public void delete(K key) {
        int hash = computeHash(key);
        buckets[hash].delete(key);
    }

    public V search(K key) {
        int hash = computeHash(key);
        Node<K, V> node = buckets[hash].findKey(key);
        return node != null ? node.getValue() : null;
    }

    public void display() {
        for (int i = 0; i < hashSize; i++) {
            System.out.printf("Bucket %d: %s%n", i, buckets[i].display());
        }
    }

    public void clear() {
        for (int i = 0; i < hashSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < hashSize; i++) {
            size += buckets[i].isEmpty() ? 0 : 1;
        }
        return size;
    }

    public static class LinkedList<K, V> {
        private Node<K, V> head;

        public void insert(K key, V value) {
            Node<K, V> existingNode = findKey(key);
            if (existingNode != null) {
                existingNode.setValue(value); 
            } else {
                if (isEmpty()) {
                    head = new Node<>(key, value);
                } else {
                    Node<K, V> temp = findEnd(head);
                    temp.setNext(new Node<>(key, value));
                }
            }
        }

        private Node<K, V> findEnd(Node<K, V> node) {
            while (node.getNext() != null) {
                node = node.getNext();
            }
            return node;
        }

        public Node<K, V> findKey(K key) {
            Node<K, V> temp = head;
            while (temp != null) {
                if ((key == null && temp.getKey() == null) || (temp.getKey() != null && temp.getKey().equals(key))) {
                    return temp;
                }
                temp = temp.getNext();
            }
            return null;
        }

        public void delete(K key) {
            if (isEmpty()) {
                return;
            }

            if ((key == null && head.getKey() == null) || (head.getKey() != null && head.getKey().equals(key))) {
                head = head.getNext();
                return;
            }

            Node<K, V> current = head;
            while (current.getNext() != null) {
                if ((key == null && current.getNext().getKey() == null) || (current.getNext().getKey() != null && current.getNext().getKey().equals(key))) {
                    current.setNext(current.getNext().getNext());
                    return;
                }
                current = current.getNext();
            }
        }

        public String display() {
            return display(head);
        }

        private String display(Node<K, V> node) {
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append(node.getKey()).append("=").append(node.getValue());
                node = node.getNext();
                if (node != null) {
                    sb.append(" -> ");
                }
            }
            return sb.toString().isEmpty() ? "null" : sb.toString();
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) { 
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
