package leetcode_top_150.sliding_window.lc209;

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum = sum - nums[left++];
            }
            right = right + 1;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
