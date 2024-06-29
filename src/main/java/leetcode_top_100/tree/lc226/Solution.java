package leetcode_top_100.tree.lc226;

import categorized.tree.base.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = invertTree(root.right);
        TreeNode rightNode = invertTree(root.left);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
