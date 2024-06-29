package categorized.tree.leetcode563;

import categorized.tree.base.TreeNode;

/**
 * 563. 二叉树的坡度
 * https://leetcode.cn/problems/binary-tree-tilt/description/
 */
public class Solution {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(dfsSum(root.left) - dfsSum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int dfsSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + dfsSum(root.left) + dfsSum(root.right);
    }
}
