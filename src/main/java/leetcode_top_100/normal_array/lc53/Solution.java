package leetcode_top_100.normal_array.lc53;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

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
}
