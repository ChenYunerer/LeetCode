package leetcode_top_100.linked_list.lc138;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node newNode = map.get(cur);
            if (cur.random != null) {
                newNode.random = map.get(cur.random);
            }
            if (cur.next != null) {
                newNode.next = map.get(cur.next);
            }
            cur = cur.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}


