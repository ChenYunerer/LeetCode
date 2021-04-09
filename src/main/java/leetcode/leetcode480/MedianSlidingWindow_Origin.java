package leetcode.leetcode480;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sliding-window-median/
 * 思路：
 * 暴力求解 超时
 * 用start end维护时间窗口对于数组中的起始位置
 * 每次移动都根据start end从源数组中获取子数组，并排序
 * 排序之后根据奇偶获取中位数
 * <p>
 * 问题：
 * 这里每次移动滑动窗口都需要对子数组进行重新排序，存在大量不必要的排序操作
 */
public class MedianSlidingWindow_Origin {

    public static void main(String[] args) {
        int[] nums = new int[]{
                2147483647, 2147483647

        };
        int k = 2;
        double[] result = medianSlidingWindow(nums, k);
        for (double item : result) {
            System.out.println(item);
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        double[] result = new double[nums.length - k + 1];
        while (end < nums.length) {
            double medianNum = getMedianNumOfArray(nums, start, end, k);
            result[start] = medianNum;
            start++;
            end++;
        }
        return result;
    }

    public static double getMedianNumOfArray(int[] nums, int start, int end, int k) {
        nums = Arrays.copyOfRange(nums, start, end + 1);
        Arrays.sort(nums);
        if (k % 2 != 0) {
            return nums[k / 2];
        } else {
            return nums[k / 2] * 1.0 / 2 + nums[k / 2 - 1] * 1.0 / 2;
        }
    }
}
