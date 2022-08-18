package basicalgorithm.tree.leetcode129;

import basicalgorithm.tree.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class Solution2 {


    /**
     * BFS
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offer(root);
        Deque<Integer> numDeque = new LinkedList<>();
        numDeque.offer(root.val);
        while (!nodeDeque.isEmpty()) {
            TreeNode treeNode = nodeDeque.poll();
            int val = numDeque.poll();
            if (treeNode.left == null && treeNode.right == null) {
                ans = ans + val;
            }
            if (treeNode.left != null) {
                nodeDeque.offer(treeNode.left);
                numDeque.offer(val * 10 + treeNode.left.val);
            }
            if (treeNode.right != null) {
                nodeDeque.offer(treeNode.right);
                numDeque.offer(val * 10 + treeNode.right.val);
            }
        }
        return ans;
    }

}
