package categorized.tree.leetcode98;

import categorized.tree.base.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class Solution1 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long low, long top) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= top) {
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, top);
    }

}
