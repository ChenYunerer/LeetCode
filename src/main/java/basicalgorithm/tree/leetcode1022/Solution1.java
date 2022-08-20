package basicalgorithm.tree.leetcode1022;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Solution1 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        Solution1 solution = new Solution1();
        int result = solution.sumRootToLeaf(root);
        System.out.println(result);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = (path << 1) + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
