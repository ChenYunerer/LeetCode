package categorized.tree.leetcode938;

import categorized.tree.base.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode.cn/problems/range-sum-of-bst/
 */
public class Solution {

    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        dfs(root.left, low, high);
        int val = root.val;
        if (val >= low && val <= high) {
            ans = ans + val;
        }
        dfs(root.right, low, high);
    }
}
