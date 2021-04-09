package other;

import java.util.HashMap;

public class LRUCache<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;
    private final HashMap<K, Node<K, V>> hashMap;
    private final int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        head = new Node<>();
        tail = new Node<>();
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        hashMap = new HashMap<>(cap);
    }

    public V get(K key) {
        Node<K, V> node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        //将该节点从原位置剥离
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //将该节点移动到链表头部
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = hashMap.get(key);
        if (node == null) {
            //如果node不存在则进行插入，判断是否达到最大容量
            if (hashMap.size() == cap) {
                //容量达到最大容量则移除末尾节点
                hashMap.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
            }
            node = new Node<>(key, value);
            //新节点加入hash表
            hashMap.put(key, node);
        }
        //将该node加到/移到链表头部
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
