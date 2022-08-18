package basicalgorithm.tree.interview0412;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.12. 求和路径
 * https://leetcode.cn/problems/paths-with-sum-lcci/
 */
public class Solution {

    int count = 0;
    int fixSum;

    List<TreeNode> visited = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        Solution solution = new Solution();
        int result = solution.pathSum(root, 3);
        System.out.println(result);
    }

    public int pathSum(TreeNode root, int sum) {
        fixSum = sum;
        visited.add(root);
        dfs(root, sum);
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
        if (!visited.contains(root)) {
            visited.add(root);
            dfs(root, fixSum);
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
