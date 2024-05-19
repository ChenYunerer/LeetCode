package leetcode_top_100.linked_list.lc146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final ListNode head;
    private final ListNode tail;
    private final Map<Integer, ListNode> map = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveNodeToFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            moveNodeToFirst(node);
        } else {
            if (map.size() == capacity) {
                ListNode lastNode = tail.pre;
                lastNode.pre.next = lastNode.next;
                lastNode.next.pre = lastNode.pre;
                map.remove(lastNode.key);
            }
            ListNode newListNode = new ListNode();
            newListNode.val = value;
            newListNode.key = key;
            map.put(key, newListNode);
            moveNodeToFirst(newListNode);
        }
    }

    private void moveNodeToFirst(ListNode node) {
        if (head.next == node) {
            return;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }

        ListNode originFirstNode = head.next;
        head.next = node;
        node.pre = head;
        originFirstNode.pre = node;
        node.next = originFirstNode;
    }


    class ListNode {
        int val;
        int key;
        ListNode pre;
        ListNode next;
    }

}
