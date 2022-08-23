package basicalgorithm.tree.leetcode1008;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 1008. 前序遍历构造二叉搜索树
 * https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        TreeUtil.printTreeNode(treeNode);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return dfs(preorder, 0, preorder.length - 1);
    }

    /**
     * start end 为闭区间
     */
    private TreeNode dfs(int[] preorder, int start, int end) {
        if (end < start || start >= preorder.length) {
            return null;
        }
        int rootVal = preorder[start];

        int leftTreeStart = end + 1;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > rootVal) {
                leftTreeStart = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(preorder, start + 1, leftTreeStart - 1);
        root.right = dfs(preorder, leftTreeStart, end);
        return root;
    }
}
