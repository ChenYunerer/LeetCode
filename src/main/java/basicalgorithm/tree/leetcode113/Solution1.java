package basicalgorithm.tree.leetcode113;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii/
 */
public class Solution1 {

    private final List<List<Integer>> result = new ArrayList<>();
    private final Deque<Integer> path = new LinkedList<>();

    /**
     * DFS优化
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        doPathSum(root, targetSum);
        return result;
    }

    public void doPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(path));
        }
        doPathSum(root.left, targetSum - root.val);
        doPathSum(root.right, targetSum - root.val);
        path.pollLast();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
