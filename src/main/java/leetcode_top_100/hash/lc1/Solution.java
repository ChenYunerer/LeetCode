package leetcode_top_100.hash.lc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/solutions/434597/liang-shu-zhi-he-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // key: num value: pos list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(target - nums[i]);
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != i) {
                        return new int[]{i, list.get(j)};
                    }
                }
            }
        }
        return null;
    }

    // best
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution().twoSum(new int[]{2,7,11,15}, 9);
    }
}
