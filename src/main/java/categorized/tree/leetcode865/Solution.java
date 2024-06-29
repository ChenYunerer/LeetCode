package categorized.tree.leetcode865;

import categorized.tree.base.TreeNode;

/**
 * 865. 具有所有最深节点的最小子树
 * https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Solution {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root, 0).node;
    }

    private Pair dfs(TreeNode root, int deep) {
        if (root == null) {
            return null;
        }
        deep = deep + 1;
        if (root.left == null && root.right == null) {
            return new Pair(root, deep);
        }
        Pair leftPair = dfs(root.left, deep);
        Pair rightPair = dfs(root.right, deep);
        if (leftPair == null || rightPair == null) {
            return leftPair != null ? leftPair : rightPair;
        }
        if (leftPair.deep == rightPair.deep) {
            return new Pair(root, leftPair.deep);
        } else {
            return leftPair.deep > rightPair.deep ? leftPair : rightPair;
        }
    }


    class Pair {
        TreeNode node;
        int deep;

        public Pair(TreeNode node, int deep) {
            this.node = node;
            this.deep = deep;
        }
    }
}
