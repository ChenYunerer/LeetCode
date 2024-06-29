package categorized.tree.leetcode563;

import categorized.tree.base.TreeNode;

/**
 * 563. 二叉树的坡度
 * https://leetcode.cn/problems/binary-tree-tilt/description/
 */
public class Solution2 {

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ans = ans + Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
