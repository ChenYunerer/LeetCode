package leetcode_top_100.tree.lc437;

import basicalgorithm.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sumMap = new HashMap<>();
        sumMap.put(0L, 1);
        return dfs(root, sumMap, 0L, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> sumMap, Long sum, int targetSum) {
        if (root == null) {
            return 0;
        }
        long currentSum = sum + root.val;
        int result = sumMap.getOrDefault(currentSum - targetSum, 0);
        sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        result = result + dfs(root.left, sumMap, currentSum, targetSum) + dfs(root.right, sumMap, currentSum, targetSum);
        sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) - 1);
        return result;
    }
}
