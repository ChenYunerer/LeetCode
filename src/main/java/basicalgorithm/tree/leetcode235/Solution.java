package basicalgorithm.tree.leetcode235;

import basicalgorithm.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        defFindPath(pathP, root, p);
        List<TreeNode> pathQ = new ArrayList<>();
        defFindPath(pathQ, root, q);

        for (int i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }
        return null;
    }

    private void defFindPath(List<TreeNode> path, TreeNode root, TreeNode target) {
        path.add(root);
        if (target.val < root.val) {
            defFindPath(path, root.left, target);
        } else if (target.val > root.val) {
            defFindPath(path, root.right, target);
        } else {
            path.add(root);
        }
    }
}
