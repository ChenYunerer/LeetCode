package basicalgorithm.divideandconquer;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 * todo 动态规划解法需要再补充 https://leetcode.cn/problems/maximum-subarray/comments/
 */
public class Solution {


    /**
     * 贪心解法
     * <p>
     * 如果 -2 1 在一起，计算起点的时候，一定是从1开始计算，因为负数只会拉低总和，这就是贪心贪的地方！
     * <p>
     * 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
     * <p>
     * 全局最优：选取最大“连续和”
     * <p>
     * 局部最优的情况下，并记录最大的“连续和”，可以推出全局最优。
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int mMax = 0;
        for (int start = 0; start < nums.length; start++) {
            mMax = mMax + nums[start];
            if (mMax > max) {
                max = mMax;
            }
            if (mMax < 0) {
                mMax = 0;
            }
        }
        return max;
    }

    /**
     * 暴力求解
     * 超时了
     */
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int start = 0; start < nums.length; start++) {
            int mMax = 0;
            for (int end = start; end < nums.length; end++) {
                mMax = mMax + nums[end];
                if (mMax > max) {
                    max = mMax;
                }
            }
        }
        return max;
    }
}
