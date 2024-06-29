package categorized.linkedList.interview1625;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.25. LRU 缓存
 * https://leetcode.cn/problems/lru-cache-lcci/
 */
public class LRUCache {
    Map<Integer, ListNode> keyNodeMap = new HashMap<>();
    ListNode vHead;
    ListNode vTail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        vHead = new ListNode();
        vTail = new ListNode();
        vHead.next = vTail;
        vTail.pre = vHead;
    }

    public int get(int key) {
        ListNode listNode = keyNodeMap.get(key);
        if (listNode == null) {
            return -1;
        }
        listNode.pre.next = listNode.next;
        listNode.next.pre = listNode.pre;

        listNode.pre = vHead;
        listNode.next = vHead.next;

        ListNode temp = vHead.next;
        vHead.next = listNode;
        temp.pre = listNode;
        return listNode.value;
    }

    public void put(int key, int value) {
        ListNode listNode = keyNodeMap.get(key);
        if (listNode == null) {
            // 容量已经到达最大 则删除链表尾部
            if (keyNodeMap.size() == capacity) {
                keyNodeMap.remove(vTail.pre.key);
                vTail.pre.pre.next = vTail;
                vTail.pre = vTail.pre.pre;
            }
            listNode = new ListNode(key, value);
            keyNodeMap.put(key, listNode);
        } else {
            listNode.pre.next = listNode.next;
            listNode.next.pre = listNode.pre;
        }
        listNode.value = value;
        listNode.pre = vHead;
        listNode.next = vHead.next;

        ListNode temp = vHead.next;
        vHead.next = listNode;
        temp.pre = listNode;
    }


    class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode(int key, int value, ListNode pre, ListNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}
