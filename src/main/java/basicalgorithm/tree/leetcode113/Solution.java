package basicalgorithm.tree.leetcode113;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii/
 */
public class Solution {

    private final List<List<Integer>> result = new ArrayList<>();

    /**
     * DFS
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        doPathSum(root, new ArrayList<>(), targetSum);
        return result;
    }


    public void doPathSum(TreeNode root, List<Integer> pathList, int targetSum) {
        if (root == null) {
            return;
        }
        pathList.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(pathList);
        }
        doPathSum(root.left, new ArrayList<>(pathList), targetSum - root.val);
        doPathSum(root.right, new ArrayList<>(pathList), targetSum - root.val);
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
