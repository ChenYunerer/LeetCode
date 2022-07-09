package basicalgorithm.recursion.leetcode617;

/**
 * 617. 合并二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            return root1 != null ? root1 : root2;
        }
        TreeNode root = new TreeNode();
        root.val = root1.val + root2.val;
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
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
