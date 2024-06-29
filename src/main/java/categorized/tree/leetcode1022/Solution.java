package categorized.tree.leetcode1022;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Solution {

    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        Solution solution = new Solution();
        int result = solution.sumRootToLeaf(root);
        System.out.println(result);
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int path) {
        if (root == null) {
            return;
        }
        path = (path << 1) + root.val;
        if (root.left == null && root.right == null) {
            ans = ans + path;
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }
}
