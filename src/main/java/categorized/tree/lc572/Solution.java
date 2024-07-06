package categorized.tree.lc572;

import categorized.tree.base.TreeNode;

/**
 * 572. 另一棵树的子树
 * https://leetcode.cn/problems/subtree-of-another-tree/description/
 */
public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return compareTree(root, subRoot) || isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    private boolean compareTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return compareTree(a.left, b.left) && compareTree(a.right, b.right);
    }

}
