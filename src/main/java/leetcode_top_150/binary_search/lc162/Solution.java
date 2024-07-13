package leetcode_top_150.binary_search.lc162;

/**
 * 162. 寻找峰值
 * https://leetcode.cn/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    /**
     * 二分
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid - 1 < 0 && nums[mid + 1] < nums[mid]) {
                return mid;
            }
            if (mid + 1 >= nums.length && nums[mid - 1] < nums[mid]) {
                return mid;
            }
            if (nums[mid + 1] < nums[mid] && nums[mid - 1] < nums[mid]) {
                return mid;
            }
            if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
