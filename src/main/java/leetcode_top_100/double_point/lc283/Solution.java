package leetcode_top_100.double_point.lc283;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    // best
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i++, j);
            }
            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
