package leetcode_top_100.tree.lc98;

import categorized.tree.base.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    Integer num = null;
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        dfs(root);
        return valid;
    }

    public void dfs(TreeNode root) {
        if (root == null && !valid) {
            return;
        }
        dfs(root.left);
        if (num == null) {
            num = root.val;
        } else {
            if (num >= root.val) {
                valid = false;
            } else {
                num = root.val;
            }
        }
        dfs(root.right);
    }
}
