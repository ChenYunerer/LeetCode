package leetcode_top_100.double_point.lc15;

import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    // best
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        right--;
                    } while (right > left && nums[right] == nums[right + 1]);
                    do {
                        left++;
                    } while (left < nums.length && nums[left] == nums[left - 1]);
                } else if (sum > 0) {
                        right--;
                } else {
                        left++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
