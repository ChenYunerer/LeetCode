package leetcode_top_150.double_point.lc11;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxSum = 0;
        while (leftIndex < rightIndex) {
            int curSum = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            maxSum = Math.max(maxSum, curSum);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxSum;
    }
}
