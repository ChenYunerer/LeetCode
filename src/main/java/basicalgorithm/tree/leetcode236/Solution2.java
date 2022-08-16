package basicalgorithm.tree.leetcode236;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution2 {

    private final Map<TreeNode, TreeNode> map = new HashMap<>();
    private final List<TreeNode> path = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        Solution2 solution = new Solution2();
        TreeNode treeNode = solution.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        def(root);

        while (p != null) {
            path.add(p);
            TreeNode parentTreeNode = map.get(p);
            p = parentTreeNode;
        }

        while (q != null) {
            if (path.contains(q)) {
                return q;
            }
            TreeNode parentTreeNode = map.get(q);
            q = parentTreeNode;
        }
        return null;
    }

    public void def(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.left, root);
        def(root.left);
        map.put(root.right, root);
        def(root.right);
    }
}
