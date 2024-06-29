package categorized.tree.interview0406;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 */
public class Solution1 {

    boolean flag = false;

    public static void main(String[] args) {
        // TreeNode root = TreeUtil.genTreeNode(new Integer[]{2, 1, 3});
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Solution1 solution = new Solution1();
        TreeNode result = solution.inorderSuccessor(root, new TreeNode(1));
        System.out.println(result);
    }

    /**
     * 这个更慢了，因为无法中断dfs
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode leftTarget = inorderSuccessor(root.left, p);
        if (flag) {
            flag = false;
            return root;
        }
        if (root.val == p.val) {
            flag = true;
        }
        TreeNode rightTarget = inorderSuccessor(root.right, p);
        return leftTarget != null ? leftTarget : rightTarget;
    }
}
