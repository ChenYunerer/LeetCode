package basicalgorithm.tree.leetcode513;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class Solution {

    /**
     * BFS
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = root.val;
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == 0) {
                    result = node.val;
                }
            }
        }
        return result;
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
