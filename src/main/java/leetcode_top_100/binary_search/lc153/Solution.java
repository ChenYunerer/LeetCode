package leetcode_top_100.binary_search.lc153;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public static void main(String[] args) {
        int ans = new Solution().findMin(new int[]{3, 1, 2});
        System.out.println(ans);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }
        }
        return min;
    }
}
