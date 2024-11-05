package leetcode_top_100.normal_array.lc53;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    // 前缀和
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int preSum = 0;
        int minPreSum = preSum;
        for (int x : nums) {
            preSum = preSum + x;
            ans = Math.max(ans, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }

    // 贪心
    public int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int subArraySum = 0;
        for (int x : nums) {
            subArraySum = subArraySum + x;
            ans = Math.max(ans, subArraySum);
            if (subArraySum < 0) {
                subArraySum = 0;
            }
        }
        return ans;
    }

}
