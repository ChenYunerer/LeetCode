package basicalgorithm.leetcode.leetcode560;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 前缀和算法
 */
public class SubarraySum_Origin {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2) == 2);
        System.out.println(subarraySum(new int[]{1}, 1) == 1);
        System.out.println(subarraySum(new int[]{1}, 0) == 0);
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0) == 3);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < sum.length; i++) {
            int a = sum[i] + k;
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] == a) {
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(nums) + " " + k + " " + count);
        return count;
    }
}
