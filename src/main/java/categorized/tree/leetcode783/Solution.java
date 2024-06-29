package categorized.tree.leetcode783;

import categorized.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 783. 二叉搜索树节点最小距离
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class Solution {

    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root, new ArrayList<>());
        return min;
    }

    private void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        dfs(root.left, path);
        if (path.size() != 0) {
            min = Math.min(min, Math.abs(root.val - path.get(path.size() - 1)));
        }
        path.add(root.val);
        dfs(root.right, path);
    }
}
