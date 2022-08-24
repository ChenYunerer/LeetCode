package basicalgorithm.tree.leetcode662;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null});
        TreeUtil.printTreeNode(root);
        Solution solution = new Solution();
        int result = solution.widthOfBinaryTree(root);
        System.out.println(result);
    }

    /**
     * 超时 内存溢出
     * 不能傻傻的把每层数据都存下来
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = -1;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            while (!deque.isEmpty() && deque.peekFirst() == null) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() == null) {
                deque.removeLast();
            }
            int levelCount = deque.size();
            maxWidth = Math.max(levelCount, maxWidth);
            for (int i = 0; i < levelCount; i++) {
                TreeNode treeNode = deque.poll();
                deque.offer(treeNode == null ? null : treeNode.left);
                deque.offer(treeNode == null ? null : treeNode.right);
            }
        }
        return maxWidth;
    }
}
