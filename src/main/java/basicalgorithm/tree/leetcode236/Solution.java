package basicalgorithm.tree.leetcode236;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        Solution solution = new Solution();
        TreeNode treeNode = solution.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = def(root, p, null);

        List<TreeNode> pathQ = def(root, q, null);

        TreeNode commonAncestor = root;
        for (int i = 0; i < Math.min(pathQ.size(), pathP.size()); i++) {
            if (pathP.get(i).val == pathQ.get(i).val) {
                commonAncestor = pathP.get(i);
            }
        }
        return commonAncestor;
    }

    /**
     * 这里每次都new ArrayList导致内存超限
     */
    public List<TreeNode> def(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (path == null) {
            path = new ArrayList<>();
        }
        path.add(root);
        if (root == null) {
            return null;
        }
        if (root.val == target.val) {
            return path;
        }
        List<TreeNode> leftResult = def(root.left, target, new ArrayList<>(path));
        if (leftResult != null) {
            return leftResult;
        }
        List<TreeNode> rightResult = def(root.right, target, new ArrayList<>(path));
        return rightResult;
    }
}
