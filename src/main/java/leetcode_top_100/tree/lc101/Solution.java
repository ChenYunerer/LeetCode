package leetcode_top_100.tree.lc101;

import categorized.tree.base.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        } else if (a == null && b == null) {
            return true;
        } else {
            return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
        }
    }
}
