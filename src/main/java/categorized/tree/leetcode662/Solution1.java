package categorized.tree.leetcode662;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class Solution1 {


    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null});
        Solution1 solution = new Solution1();
        int result = solution.widthOfBinaryTree(root);
        System.out.println(result);
    }

    /**
     * 利用完全二叉树的编号性质
     * 1
     * 2       3
     * 4    5  6      7
     * <p>
     * leftChildIndex = rootIndex * 2
     * rightChildIndex = rootIndex * 2 + 1
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = -1;
        Deque<TreeNodeWrapper> deque = new LinkedList<>();
        deque.offer(new TreeNodeWrapper(root, 1));
        while (!deque.isEmpty()) {
            maxWidth = Math.max(maxWidth, deque.peekLast().index - deque.peekFirst().index + 1);
            int levelCount = deque.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNodeWrapper treeNodeWrapper = deque.poll();
                if (treeNodeWrapper.node.left != null) {
                    deque.offer(new TreeNodeWrapper(treeNodeWrapper.node.left, treeNodeWrapper.index * 2));
                }
                if (treeNodeWrapper.node.right != null) {
                    deque.offer(new TreeNodeWrapper(treeNodeWrapper.node.right, treeNodeWrapper.index * 2 + 1));
                }
            }
        }
        return maxWidth;
    }

    class TreeNodeWrapper {
        TreeNode node;
        int index;

        public TreeNodeWrapper(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
