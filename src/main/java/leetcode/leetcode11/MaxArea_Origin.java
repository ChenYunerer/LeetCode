package leetcode.leetcode11;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 思路：
 * 暴力遍历
 * 问题：
 * 时间复杂度为n^2导致超时
 */
public class MaxArea_Origin {

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}
