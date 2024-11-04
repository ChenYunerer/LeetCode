package leetcode_top_100.normal_array.lc53;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    // 贪心
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

    // 前缀和
    public int maxSubArray1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int x : nums) {
            preSum += x; // 当前的前缀和
            ans = Math.max(ans, preSum - minPreSum); // 减去前缀和的最小值
            minPreSum = Math.min(minPreSum, preSum); // 维护前缀和的最小值
        }
        return ans;
    }

}
