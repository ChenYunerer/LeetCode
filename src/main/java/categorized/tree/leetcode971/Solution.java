package categorized.tree.leetcode971;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/
 */
public class Solution {

    List<Integer> ans = new ArrayList<>();

    int index = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 2, 3});
        Solution solution = new Solution();
        List<Integer> res = solution.flipMatchVoyage(root, new int[]{1, 3, 2});
        System.out.println(res);
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        if (!ans.isEmpty() && ans.get(0) == -1) {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val != voyage[index]) {
            ans.clear();
            ans.add(-1);
            return;
        }
        index++;
        if (root.left != null && root.left.val != voyage[index]) {
            ans.add(root.val);
            dfs(root.right, voyage);
            dfs(root.left, voyage);
        } else {
            dfs(root.left, voyage);
            dfs(root.right, voyage);
        }
    }
}
