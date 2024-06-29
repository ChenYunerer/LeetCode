package categorized.tree.leetcode437;

import categorized.tree.base.TreeNode;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii/
 * todo 尝试前缀和算法
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        return (int) (dfs(root, targetSum) + (root == null ? 0 : (pathSum(root.left, targetSum) + pathSum(root.right, targetSum))));
    }

    private long dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        long leftVal = dfs(root.left, targetSum - root.val);
        long rightVal = dfs(root.right, targetSum - root.val);
        return (root.val == targetSum ? 1 : 0) + leftVal + rightVal;
    }
}
