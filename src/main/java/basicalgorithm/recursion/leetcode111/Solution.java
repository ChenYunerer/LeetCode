package basicalgorithm.recursion.leetcode111;

/**
 * 111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int deepR = minDepth(root.right);
        int deepL = minDepth(root.left);
        if (deepR != 0 && deepL != 0) {
            return 1 + Math.min(deepR, deepL);
        } else {
            return 1 + Math.max(deepR, deepL);
        }
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
