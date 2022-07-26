package basicalgorithm.linkedList.leetcode138;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode.cn/problems/copy-list-with-random-pointer/
 */
public class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node copyNodeVHead = new Node(0);
        Node cur = head;
        Node copyNodeCur = copyNodeVHead;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            nodeMap.put(cur, copyNode);

            copyNodeCur.next = copyNode;
            copyNodeCur = copyNode;

            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copyNode = nodeMap.get(cur);
            Node randomNode = cur.random == null ? null : nodeMap.get(cur.random);
            copyNode.random = randomNode;

            cur = cur.next;
        }
        return copyNodeVHead.next;
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
