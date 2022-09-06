package basicalgorithm.tree.leetcode437;

import basicalgorithm.tree.base.TreeNode;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii/
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum) + pathSum(root == null ? null : root.left, targetSum) + pathSum(root == null ? null : root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            return 1;
        }
        targetSum = targetSum - root.val;
        int leftVal = dfs(root.left, targetSum);
        int rightVal = dfs(root.right, targetSum);
        return leftVal + rightVal;
    }
}
