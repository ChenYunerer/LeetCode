package basicalgorithm.tree.leetcode1026;

import basicalgorithm.tree.base.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 * todo review
 */
public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 默认情况下，已知的最小最大边界既是root.val
        return dfs(root, root.val, root.val);
    }


    /**
     * DFS
     *
     * @param root 树节点
     * @param min  已知的最小边界值
     * @param max  已知的最大边界值
     * @return 最大差值
     */
    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            // 直到root == null则说明到了最底层节点，此时该DFS路径的上下边界值已经是已知的最大范围，则计算差值
            return max - min;
        }
        // 每经过一个节点则根据当前节点值，重新计算最小边界和最大边界值（不断扩张已知的范围）
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int leftMaxAncestorDiff = dfs(root.left, min, max);
        int rightMaxAncestorDiff = dfs(root.right, min, max);
        // 计算最大差值
        return Math.max(leftMaxAncestorDiff, rightMaxAncestorDiff);
    }

}
