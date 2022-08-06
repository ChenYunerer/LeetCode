package basicalgorithm.tree.leetcode114;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {

    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre == null) {
            pre = root;
        }
        TreeNode rightTemp = root.right;
        if (pre != root) {
            pre.right = root;
            pre.left = null;
            pre = root;
        }
        flatten(root.left);
        flatten(rightTemp);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
