package basicalgorithm.tree.leetcode404;

/**
 * 404. 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 */
public class Solution {

    int sum = 0;
    boolean left = false;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        if (root.left == null && root.right == null && left) {
            sum = sum + root.val;
        }
        left = true;
        sumOfLeftLeaves(root.left);
        left = false;
        sumOfLeftLeaves(root.right);
        return sum;
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
