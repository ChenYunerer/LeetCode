package basicalgorithm.tree.leetcode105;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] preorder = new int[]{3,9,20,15,7};
        //int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{1, 2};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        TreeUtil.printTreeNode(treeNode);
    }

    /**
     * 执行用时：20 ms, 在所有 Java 提交中击败了5.73%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了12.72%的用户
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        return dfs(preorderList, inorder, 0, inorder.length - 1);
    }

    /**
     * start end 闭区间
     */
    private TreeNode dfs(List<Integer> preorder, int[] inorder, int start, int end) {
        if (end < start || start >= inorder.length) {
            return null;
        }
        int rootIndex = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder.get(0)) {
                rootIndex = i;
                preorder.remove(0);
                break;
            }
        }
        TreeNode root = new TreeNode();
        root.val = inorder[rootIndex];

        TreeNode leftNode = dfs(preorder, inorder, start, rootIndex - 1);
        root.left = leftNode;

        TreeNode rightNode = dfs(preorder, inorder, rootIndex + 1, end);
        root.right = rightNode;

        return root;
    }

}
