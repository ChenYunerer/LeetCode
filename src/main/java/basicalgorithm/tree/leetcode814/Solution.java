package basicalgorithm.tree.leetcode814;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 814. 二叉树剪枝
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, null, 0, 0, 1});
        Solution solution = new Solution();
        TreeNode result = solution.pruneTree(root);
        System.out.println(result);
    }

    public TreeNode pruneTree(TreeNode root) {
        TreeNode vNode = new TreeNode(1);
        vNode.right = root;
        dfs(vNode.right, vNode, 1);
        return vNode.right;
    }

    public boolean dfs(TreeNode root, TreeNode parent, int leftOrRight) {
        if (root == null) {
            return false;
        }
        boolean leftResult = dfs(root.left, root, 0);
        boolean rightResult = dfs(root.right, root, 1);
        if (root.val != 1 && !leftResult && !rightResult) {
            if (leftOrRight == 0) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return false;
        } else {
            return true;
        }
    }
}
