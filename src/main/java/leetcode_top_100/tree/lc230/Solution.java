package leetcode_top_100.tree.lc230;

import basicalgorithm.tree.base.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    int step = 0;
    Integer num;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return num;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || step == k) {
            return;
        }
        dfs(root.left, k);
        if (step != k) {
            num = root.val;
            step++;
        }
        dfs(root.right, k);
    }
}
