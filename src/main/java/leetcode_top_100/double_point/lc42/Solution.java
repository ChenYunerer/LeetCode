package leetcode_top_100.double_point.lc42;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/submissions/528138012/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
