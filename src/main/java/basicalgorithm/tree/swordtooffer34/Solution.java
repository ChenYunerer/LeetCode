package basicalgorithm.tree.swordtooffer34;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Solution {

    private final List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        Solution solution = new Solution();
        List<List<Integer>> result = solution.pathSum(root, 22);
        System.out.println(result);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, target, null);
        return result;
    }

    private void dfs(TreeNode root, int target, List<Integer> path) {
        if (path == null) {
            path = new ArrayList<>();
        }
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, target - root.val, path);
        dfs(root.right, target - root.val, path);
        path.remove(path.size() - 1);
    }
}
