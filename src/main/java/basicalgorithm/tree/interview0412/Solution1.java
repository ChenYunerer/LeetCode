package basicalgorithm.tree.interview0412;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

/**
 * 面试题 04.12. 求和路径
 * https://leetcode.cn/problems/paths-with-sum-lcci/
 */
public class Solution1 {

    int count = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        Solution1 solution = new Solution1();
        int result = solution.pathSum(root, 3);
        System.out.println(result);
    }

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        if (root != null) {
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return count;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        if (sum == 0) {
            count++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
