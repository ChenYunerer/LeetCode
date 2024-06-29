package leetcode_top_100.tree.lc114;

import categorized.tree.base.TreeNode;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            flatten(root.right);
        } else {
            flatten(root.left);
            flatten(root.right);
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            TreeNode oldRight = root.right;
            root.right = root.left;
            root.left = null;
            cur.right = oldRight;
        }
    }


}
