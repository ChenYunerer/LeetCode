package leetcode_top_100.normal_array.lc56;

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        // Step 1: 将非正整数和大于数组长度的数修改为 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Step 2: 将每个数字对应的位置标记为负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[num] = -Math.abs(nums[num]);
            }
        }

        // Step 3: 找到第一个正数的位置，即缺失的最小正整数
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        // 如果都是负数，说明 [1, n-1] 都出现了，返回 n
        if (nums[0] > 0) {
            return n;
        }

        // 如果第一个位置仍然为正数，说明数组中只有一个元素，返回 n+1
        return n + 1;
    }

}
