package basicalgorithm.tree.leetcode1026;

import basicalgorithm.tree.base.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 * todo review
 */
public class Solution1 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了75.93%的用户
     */
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
        // maxAncestorDiff已经对root判空了，这里就不需要判空了
        // 每经过一个节点，则根据当前节点值，重新计算最小边界和最大边界值（不断扩张已知的范围）
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        if (root.left == null && root.right == null) {
            // 到叶子节点的时候，此时该DFS路径的上下边界值已经是已知的最大范围，则计算差值
            return max - min;
        }
        // 递归处理左子树（路径往左走）
        int leftMaxAncestorDiff = dfs(root.left, min, max);
        // 递归处理右子树（路径往右走）
        int rightMaxAncestorDiff = dfs(root.right, min, max);
        // 反回最大差值
        return Math.max(leftMaxAncestorDiff, rightMaxAncestorDiff);
    }

}
