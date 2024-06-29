package categorized.tree.leetcode105;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution1 {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        //int[] preorder = new int[]{1, 2};
        //int[] inorder = new int[]{1, 2};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        TreeUtil.printTreeNode(treeNode);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了55.50%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了83.91%的用户
     */
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
