package basicalgorithm.tree.leetcode235;

import basicalgorithm.tree.base.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Solution1 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
