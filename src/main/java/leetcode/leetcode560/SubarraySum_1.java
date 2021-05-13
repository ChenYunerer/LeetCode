package leetcode.leetcode560;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 前缀和+Hash表优化算法
 */
public class SubarraySum_1 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2) == 2);
        System.out.println(subarraySum(new int[]{1}, 1) == 1);
        System.out.println(subarraySum(new int[]{1}, 0) == 0);
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0) == 3);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        System.out.println(Arrays.toString(nums) + " " + k + " " + count);
        return count;
    }
}
