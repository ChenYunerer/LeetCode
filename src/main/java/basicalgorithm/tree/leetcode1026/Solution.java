package basicalgorithm.tree.leetcode1026;

import basicalgorithm.tree.base.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 */
public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val);
    }


    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        int leftMaxAncestorDiff = dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        int rightMaxAncestorDiff = dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
        // todo 最终答案加不加这一行都是ok的，但是我觉得就得加这一行，为啥不加也行
        int currentMaxAncestorDiff = max - min;
        return Math.max(Math.max(leftMaxAncestorDiff, rightMaxAncestorDiff), currentMaxAncestorDiff);
    }

}
