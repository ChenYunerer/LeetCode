package basicalgorithm.tree.leetcode783;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class Solution3 {

    int preVal = -1;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 0, 48, null, null, 12, 49});
        Solution3 solution = new Solution3();
        int result = solution.minDiffInBST(root);
        System.out.println(result);
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minDiffInBST(root.left);
        int curMin = preVal != -1 ? root.val - preVal : Integer.MAX_VALUE;
        preVal = root.val;
        int rightMin = minDiffInBST(root.right);
        return Math.min(leftMin, Math.min(rightMin, curMin));
    }
}
