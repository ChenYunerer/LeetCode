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
     *
     * 对于数组 [2,3,1,2,4,2,3]，
     * 初始位置是下标 0，从下标 0 出发，最远可到达下标 2。下标 0 可到达的位置中，
     * 下标 1 的值是 3，从下标 1 出发可以达到更远的位置，因此第一步到达下标 1。
     *
     * 从下标 1 出发，最远可到达下标 4。下标 1 可到达的位置中，下标 4 的值是 4 ，
     * 从下标 4 出发可以达到更远的位置，因此第二步到达下标 4。
     *
     * 在具体的实现中，我们维护当前能够到达的最大下标位置，记为边界。
     * 我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
     *
     * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
     * 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
     * 如果访问最后一个元素，在边界正好为最后一个位置的情况下，
     * 我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
     *
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
