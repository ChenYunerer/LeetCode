package categorized.binary_search.lc268;

import java.util.Arrays;

/**
 * 268. 丢失的数字
 * https://leetcode.cn/problems/missing-number/description/
 */
public class Solution {


    /**
     * 非最优
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }


    /**
     * 二分 不是最优
     */
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                if (mid - 1 < 0 || mid - 1 == nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return nums.length;
    }
}
