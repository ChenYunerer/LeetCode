package categorized.tree.leetcode114;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {

    /**
     * 前一个节点
     */
    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre == null) {
            pre = root;
        }
        // 事先把right节点记录下来，避免递归把right引用改了
        TreeNode rightTemp = root.right;
        if (pre != root) {
            // 进行链表化操作，这里会改pre的right引用，所以上面的right得事先取出来
            pre.right = root;
            pre.left = null;
            pre = root;
        }
        flatten(root.left);
        flatten(rightTemp);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
