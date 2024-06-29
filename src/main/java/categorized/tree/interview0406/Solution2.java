package categorized.tree.interview0406;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 */
public class Solution2 {


    public static void main(String[] args) {
        // TreeNode root = TreeUtil.genTreeNode(new Integer[]{2, 1, 3});
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Solution2 solution = new Solution2();
        TreeNode result = solution.inorderSuccessor(root, new TreeNode(1));
        System.out.println(result);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }
}
