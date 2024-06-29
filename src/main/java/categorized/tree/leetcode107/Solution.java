package categorized.tree.leetcode107;

import categorized.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int levelNodeCount = deque.size();
            List<Integer> levelList = new ArrayList<>(levelNodeCount);
            for (int i = 0; i < levelNodeCount; i++) {
                TreeNode treeNode = deque.poll();
                levelList.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
            }
            result.add(0, levelList);
        }
        return result;
    }
}
