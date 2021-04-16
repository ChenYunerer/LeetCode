package leetcode.leetcode11;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 思路：
 * 最大面积=底边长度*最低的高
 * i j分别表示左右边界，每次移动的时候移动小的那一个，保留大的一个，才有可能有最大解
 */
public class MaxArea_1 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(area, maxArea);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}
