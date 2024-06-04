package leetcode_top_100.back_tracking.lc78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            dfs(0, i, 0, nums, new boolean[nums.length], new ArrayList<>());
        }
        return ans;
    }

    private void dfs(int deep, int deepLimit, int indexStart, int[] nums, boolean[] visitedNums, List<Integer> path) {
        if (deep >= deepLimit) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = indexStart; i < nums.length; i++) {
            if (!visitedNums[i]) {
                visitedNums[i] = true;
                path.add(nums[i]);
                dfs(deep + 1, deepLimit, i + 1, nums, visitedNums, path);
                visitedNums[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
