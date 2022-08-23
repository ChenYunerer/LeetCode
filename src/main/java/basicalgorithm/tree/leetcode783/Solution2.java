package basicalgorithm.tree.leetcode783;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class Solution2 {

    int min = Integer.MAX_VALUE;
    int preVal = -1;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 0, 48, null, null, 12, 49});
        Solution2 solution = new Solution2();
        int result = solution.minDiffInBST(root);
        System.out.println(result);
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (preVal != -1) {
            min = Math.min(min, root.val - preVal);
        }
        preVal = root.val;
        dfs(root.right);
    }
}
