package categorized.tree.leetcode116;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
public class Solution {

    /**
     * BFS
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            Node pre = queue.peek();
            for (int i = 0; i < levelCount; i++) {
                Node curNode = queue.poll();
                if (pre != curNode) {
                    pre.next = curNode;
                    pre = curNode;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
