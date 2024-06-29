package categorized.tree.leetcode938;

import categorized.tree.base.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode.cn/problems/range-sum-of-bst/
 */
public class Solution1 {


    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


}
