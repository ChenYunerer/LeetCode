package leetcode_top_100.double_point.lc15;

import java.util.*;

/**
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    // 转变成两数之和问题再处理 贼耗时
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(sum - nums[j])) {
                    Integer[] array = {nums[i], nums[j], sum - nums[j]};
                    Arrays.sort(array);
                    List<Integer> list = Arrays.asList(array);
                    res.add(list);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(res);
    }
}
