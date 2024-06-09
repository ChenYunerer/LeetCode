package leetcode_top_100.binary_search.lc35;

/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        return doSearchInsert(nums, target, 0, nums.length - 1);
    }

    public int doSearchInsert(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return doSearchInsert(nums, target, left, mid - 1);
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return doSearchInsert(nums, target, mid + 1, right);
        }
        return -1;
    }

}
