package categorized.tree.interview0406;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 */
public class Solution {
    boolean flag = false;

    TreeNode ans = null;

    public static void main(String[] args) {
        // TreeNode root = TreeUtil.genTreeNode(new Integer[]{2, 1, 3});
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Solution solution = new Solution();
        TreeNode result = solution.inorderSuccessor(root, new TreeNode(1));
        System.out.println(result);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        dfs(root, p);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode p) {
        // 如果ans有值了，就可以中断dfs了（直接返回）
        if (root == null || ans != null) {
            return;
        }
        dfs(root.left, p);
        if (flag) {
            flag = false;
            ans = root;
        }
        if (root.val == p.val) {
            flag = true;
        }
        dfs(root.right, p);
    }
}
