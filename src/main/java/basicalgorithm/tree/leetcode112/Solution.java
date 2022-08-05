package basicalgorithm.tree.leetcode112;

/**
 * 112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return doHasPathSum(root, 0, targetSum);
    }

    public boolean doHasPathSum(TreeNode root, int curSum, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (curSum + root.val) == targetSum;
        }
        return doHasPathSum(root.left, curSum + root.val, targetSum) || doHasPathSum(root.right, curSum + root.val, targetSum);
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
