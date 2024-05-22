package leetcode_top_100.tree.lc543;

import basicalgorithm.tree.base.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDeep(root);
        return maxDiameter;
    }

    public int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);
        int currentHigh = Math.max(leftDeep, rightDeep) + 1;
        int diameter = leftDeep + rightDeep;
        if (maxDiameter < diameter) {
            maxDiameter = diameter;
        }
        return currentHigh;
    }
}
