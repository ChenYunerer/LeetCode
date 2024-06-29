package categorized.tree.leetcode129;

import categorized.tree.base.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class Solution {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int pathVal) {
        if (root == null) {
            return;
        }
        pathVal = pathVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans = ans + pathVal;
        }
        dfs(root.left, pathVal);
        dfs(root.right, pathVal);
    }
}
