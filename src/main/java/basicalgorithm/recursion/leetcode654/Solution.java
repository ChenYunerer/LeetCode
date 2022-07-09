package basicalgorithm.recursion.leetcode654;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 * todo
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
