package basicalgorithm.tree.leetcode1325;

import basicalgorithm.tree.base.TreeNode;

/**
 * 1325. 删除给定值的叶子节点
 * https://leetcode.cn/problems/delete-leaves-with-a-given-value/
 */
public class Solution {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
