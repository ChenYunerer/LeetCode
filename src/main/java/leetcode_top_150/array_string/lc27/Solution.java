package leetcode_top_150.array_string.lc27;

import java.util.Arrays;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int ans = new Solution().removeElement1(nums, 2);
        System.out.println(ans);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public int removeElement(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int tempIndex = 0;
        for (int i : nums) {
            if (i != val) {
                temp[tempIndex] = i;
                tempIndex++;
            }
        }
        if (tempIndex >= 0) System.arraycopy(temp, 0, nums, 0, tempIndex);
        return tempIndex;
    }

    public int removeElement1(int[] nums, int val) {
        int leftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[leftIndex++] = nums[i];
            }
        }
        return leftIndex;
    }
}
