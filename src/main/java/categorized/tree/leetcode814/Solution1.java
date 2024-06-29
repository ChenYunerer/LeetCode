package categorized.tree.leetcode814;

import categorized.tree.base.TreeNode;

/**
 * 814. 二叉树剪枝
 * https://leetcode.cn/problems/binary-tree-pruning/
 * todo review
 */
public class Solution1 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
