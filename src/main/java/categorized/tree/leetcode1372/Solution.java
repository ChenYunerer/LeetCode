package categorized.tree.leetcode1372;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

/**
 * 1372. 二叉树中的最长交错路径
 * https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1});
        Solution solution = new Solution();
        int result = solution.longestZigZag(root);
        System.out.println(result);
    }

    /**
     * 暴力求解 超时了
     */
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root, -1, -1), dfs(root, 1, -1));
    }

    private int dfs(TreeNode root, int direction, int length) {
        if (root == null) {
            return length;
        }
        length = length + 1;
        return Math.max(dfs(direction == 1 ? root.right : root.left, -direction, length), longestZigZag(direction == 1 ? root.right : root.left));
    }
}
