package basicalgorithm.tree.leetcode987;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 987. 二叉树的垂序遍历
 * https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class Solution {

    /**
     * col - row - list
     */
    Map<Integer, Map<Integer, List<Integer>>> matrixMap = new TreeMap<>();

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Solution solution = new Solution();
        List result = solution.verticalTraversal(root);
        System.out.println(result);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, List<Integer>> key : matrixMap.values()) {
            List<Integer> subAns = new ArrayList<>();
            for (List<Integer> list : key.values()) {
                // 这个list的sort本来是不用加的，但是leetcode有问题，需要加上
                list.sort(Integer::compareTo);
                subAns.addAll(list);
            }
            ans.add(subAns);
        }
        return ans;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        Map<Integer, List<Integer>> rowMap = matrixMap.computeIfAbsent(col, k -> new TreeMap<>());
        List<Integer> slotList = rowMap.computeIfAbsent(row, k -> new ArrayList<>());
        slotList.add(root.val);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
