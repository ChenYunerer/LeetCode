package basicalgorithm.tree.leetcode98;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class Solution {

    private Integer minVal;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{2, 2, 2});
        Solution solution = new Solution();
        boolean result = solution.isValidBST(root);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftResult = isValidBST(root.left);
        if (minVal == null) {
            minVal = root.val;
        } else {
            if (root.val <= minVal) {
                return false;
            } else {
                minVal = root.val;
            }
        }
        boolean rightResult = isValidBST(root.right);
        return leftResult && rightResult;
    }
}
