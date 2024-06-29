package categorized.tree.leetcode783;

import categorized.tree.base.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class Solution4 {


    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private int dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return max - min < 0 ? Integer.MAX_VALUE : max - min;
        }
        int leftMinDiff = dfs(root.left, min, root.val);
        int rightMinDiff = dfs(root.right, root.val, max);
        // todo 最终答案加不加这一行都是ok的，但是我觉得就得加这一行，为啥不加也行
        int currentMinDiff = max - min < 0 ? Integer.MAX_VALUE : max - min;
        return Math.min(Math.min(leftMinDiff, rightMinDiff), currentMinDiff);
    }

}
