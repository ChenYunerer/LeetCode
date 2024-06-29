package categorized.tree.leetcode865;

import categorized.tree.base.TreeNode;

/**
 * 865. 具有所有最深节点的最小子树
 * https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Solution1 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root, 0).node;
    }

    private Pair dfs(TreeNode root, int deep) {
        if (root == null) {
            return new Pair(null, deep);
        }
        Pair leftPair = dfs(root.left, deep + 1);
        Pair rightPair = dfs(root.right, deep + 1);
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
