package basicalgorithm.tree.leetcode116;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
public class Solution1 {

    private Node parent;

    /**
     * DFS 前序遍历 且记录parent指针
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (parent != null) {
            if (root != parent.right) {
                root.next = parent.right;
            } else if (parent.next != null) {
                root.next = parent.next.left;
            }
        }
        parent = root;
        connect(root.left);
        parent = root;
        connect(root.right);
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
