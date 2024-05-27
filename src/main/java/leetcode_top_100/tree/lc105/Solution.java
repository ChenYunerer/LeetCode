package leetcode_top_100.tree.lc105;

import basicalgorithm.tree.base.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> preorderDeque = new LinkedList<>();
        for (int item : preorder) {
            preorderDeque.offer(item);
        }
        for (int index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }
        return dfs(preorderDeque, inorder, 0, inorder.length - 1);
    }

    /**
     * start end 闭区间
     */
    private TreeNode dfs(Deque<Integer> preorder, int[] inorder, int start, int end) {
        if (end < start || start >= inorder.length) {
            return null;
        }
        int rootVal = preorder.poll();
        int rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode();
        root.val = rootVal;

        TreeNode leftNode = dfs(preorder, inorder, start, rootIndex - 1);
        root.left = leftNode;

        TreeNode rightNode = dfs(preorder, inorder, rootIndex + 1, end);
        root.right = rightNode;

        return root;
    }

}
