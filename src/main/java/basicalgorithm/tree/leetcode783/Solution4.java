package basicalgorithm.tree.leetcode783;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 * todo review 搞不懂
 */
public class Solution4 {


    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 0, 48, null, null, 12, 49});
        Solution4 solution = new Solution4();
        int result = solution.minDiffInBST(root);
        System.out.println(result);
    }

    public int minDiffInBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int dfs(TreeNode node, int lower, int upper) {
        if (node == null) {
            return upper - lower;
        }
        int left = dfs(node.left, lower, node.val);
        int right = dfs(node.right, node.val, upper);
        return Math.min(left, right);
    }
}
