package basicalgorithm.tree.leetcode144;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class Solution {

    private final List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, null, 2, 3});
        Solution solution = new Solution();
        List<Integer> result = solution.preorderTraversal(root);
        for (Integer integer : result) {
            System.out.print(" " + integer);
        }
    }

    /**
     * 递归
     */
    public List<Integer> preorderTraversal0(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal0(root.left);
        preorderTraversal0(root.right);
        return result;
    }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                deque.push(root);
                root = root.left;
            }
            TreeNode node = deque.pop();
            root = node.right;
        }
        return result;
    }

}
