package leetcode_top_100.binary_search.lc34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int targetPosition = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                targetPosition = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (targetPosition == -1) {
            return new int[]{-1, -1};
        }
        left = targetPosition;
        right = targetPosition;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right <= nums.length - 1 && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}
