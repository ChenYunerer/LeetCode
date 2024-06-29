package leetcode_top_100.greedy.lc45;

/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    int minStepCount = Integer.MAX_VALUE;

    /**
     * 回溯（暴力搜索 会超时）
     */
    public int jump(int[] nums) {
        dfs(0, nums, 0);
        return minStepCount;
    }

    private void dfs(int index, int[] nums, int stepCount) {
        if (index >= nums.length - 1) {
            minStepCount = Math.min(minStepCount, stepCount);
            return;
        }
        if (stepCount > minStepCount) {
            return;
        }
        for (int i = nums[index]; i > 0; i--) {
            dfs(index + i, nums, stepCount + 1);
        }
    }


    /**
     * best
     */
    public int jump1(int[] nums) {
        // 当前所在下标
        int curIndex = 0;
        int step = 0;
        while (curIndex < nums.length - 1) {
            // 判断当前所在位置是否已经能到达最后
            if (curIndex + nums[curIndex] >= nums.length - 1) {
                step++;
                break;
            }
            // 如果当前所在位置还无法到达最后
            int maxDistanceIndex = -1;
            int nextIndex = -1;
            for (int i = 1; i <= nums[curIndex]; i++) {
                if (curIndex + i < nums.length && curIndex + i + nums[curIndex + i] > maxDistanceIndex) {
                    maxDistanceIndex = curIndex + i + nums[curIndex + i];
                    nextIndex = curIndex + i;
                }
            }
            curIndex = nextIndex;
            step++;
        }
        return step;
    }

    /**
     * 官方best
     */
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
