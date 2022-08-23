package basicalgorithm.tree.leetcode783;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class Solution1 {

    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{27, null, 34, null, 58, 50, null, 44});
        Solution1 solution = new Solution1();
        int result = solution.minDiffInBST(root);
        System.out.println(result);
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root, new LinkedList<>());
        return min;
    }

    private void dfs(TreeNode root, Deque<Integer> preVal) {
        if (root == null) {
            return;
        }
        dfs(root.left, preVal);
        if (!preVal.isEmpty()) {
            min = Math.min(min, Math.abs(root.val - preVal.poll()));
        }
        preVal.offer(root.val);
        dfs(root.right, preVal);
    }
}
