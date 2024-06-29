package categorized.tree.leetcode331;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化
 * https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        Deque<Integer> deque = new LinkedList<>();
        for (String str : array) {
            deque.offer(str.equals("#") ? null : Integer.parseInt(str));
        }
        Integer firstInt = deque.poll();
        TreeNode root = firstInt == null ? null : new TreeNode(firstInt);

        return dfs(root, deque) && deque.isEmpty();
    }

    public boolean dfs(TreeNode root, Deque<Integer> deque) {
        if (root == null) {
            return true;
        }
        if (deque.isEmpty()) {
            return false;
        }
        Integer leftVal = deque.poll();
        root.left = leftVal == null ? null : new TreeNode(leftVal);
        boolean leftValid = dfs(root.left, deque);

        if (deque.isEmpty()) {
            return false;
        }
        Integer rightVal = deque.poll();
        root.right = rightVal == null ? null : new TreeNode(rightVal);
        boolean rightValid = dfs(root.right, deque);
        return leftValid && rightValid;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
