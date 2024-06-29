package categorized.recursion.leetcode110;

/**
 * 110. 平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/
 */
public class Solution {


    public boolean isBalanced(TreeNode root) {
        int result = getDeepOfTree(root);
        return result != -1;
    }

    public int getDeepOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = getDeepOfTree(root.left);
        int rightDeep = getDeepOfTree(root.right);
        if (leftDeep == -1 || rightDeep == -1 || Math.abs(leftDeep - rightDeep) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDeep, rightDeep);
    }

    class TreeNode {
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
