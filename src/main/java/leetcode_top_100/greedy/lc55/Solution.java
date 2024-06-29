package leetcode_top_100.greedy.lc55;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    /**
     * 回溯（暴力搜索，会超时）
     */
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }

    private boolean dfs(int index, int[] nums) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        boolean ans = false;
        for (int i = nums[index]; i > 0; i--) {
            ans = ans || dfs(index + i, nums);
        }
        return ans;
    }

    /**
     * best
     */
    public boolean canJump1(int[] nums) {
        int maxDistanceIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDistanceIndex >= nums.length - 1) {
                return true;
            }
            if (i <= maxDistanceIndex) {
                maxDistanceIndex = Math.max(maxDistanceIndex, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
