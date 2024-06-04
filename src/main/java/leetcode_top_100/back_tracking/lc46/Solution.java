package leetcode_top_100.back_tracking.lc46;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(ans);
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visitedNums = new boolean[nums.length];
        dfs(0, nums, visitedNums, new ArrayList<>());
        return ans;
    }

    private void dfs(int index, int[] nums, boolean[] visitedNums, List<Integer> path) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visitedNums[i]) {
                visitedNums[i] = true;
                path.add(nums[i]);
                dfs(index + 1, nums, visitedNums, path);
                visitedNums[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
