package basicalgorithm.tree.leetcode129;

import basicalgorithm.tree.base.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class Solution1 {


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pathVal) {
        if (root == null) {
            return 0;
        }
        pathVal = pathVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            return pathVal;
        }
        return dfs(root.left, pathVal) + dfs(root.right, pathVal);
    }
}
