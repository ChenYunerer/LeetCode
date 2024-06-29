package categorized.tree.leetcode543;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 */
public class Solution {

    int max = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        int result = solution.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return max;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = dfs(root.left);
        int rightDeep = dfs(root.right);
        max = Math.max(max, leftDeep + rightDeep);
        return 1 + Math.max(leftDeep, rightDeep);
    }
}
