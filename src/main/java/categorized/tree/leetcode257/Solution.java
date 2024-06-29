package categorized.tree.leetcode257;

import categorized.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class Solution {

    private final List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, "" + root.val);
        return result;
    }

    public void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val);
        }
    }
}
