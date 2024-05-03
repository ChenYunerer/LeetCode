package leetcode_top_100.normal_array.lc189;

/**
 * 189. 轮转数组
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    /**
     * 空间复杂度O(n)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, nums.length);
    }

    /**
     * 空间复杂度O(1)
     */
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
