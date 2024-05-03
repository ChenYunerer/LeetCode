package leetcode_top_100.normal_array.lc238;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        if (nums.length == 1) return new int[]{nums[0]};

        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

}
