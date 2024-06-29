package categorized.tree.leetcode965;

import categorized.tree.base.TreeNode;

/**
 * 965. 单值二叉树
 * https://leetcode.cn/problems/univalued-binary-tree/
 */
public class Solution {

    boolean ans = true;
    TreeNode pre;

    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!ans) {
            return;
        }
        if (pre != null && pre.val != root.val) {
            ans = false;
            return;
        }
        pre = root;
        dfs(root.left);
        dfs(root.right);
    }
}
