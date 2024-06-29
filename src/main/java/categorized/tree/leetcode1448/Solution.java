package categorized.tree.leetcode1448;

import categorized.tree.base.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
 */
public class Solution {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int pathMaxVal) {
        if (root == null) {
            return 0;
        }
        if (root.val >= pathMaxVal) {
            return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
        } else {
            return dfs(root.left, pathMaxVal) + dfs(root.right, pathMaxVal);
        }
    }
}
