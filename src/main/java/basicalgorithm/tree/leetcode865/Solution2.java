package basicalgorithm.tree.leetcode865;

import basicalgorithm.tree.base.TreeNode;

/**
 * 865. 具有所有最深节点的最小子树
 * https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Solution2 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);
        if (leftPair.deep == rightPair.deep) {
            return new Pair(root, leftPair.deep + 1);
        } else {
            return leftPair.deep > rightPair.deep ? new Pair(leftPair.node, leftPair.deep + 1) : new Pair(rightPair.node, rightPair.deep + 1);
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
