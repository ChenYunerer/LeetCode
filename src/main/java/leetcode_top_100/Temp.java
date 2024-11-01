package leetcode_top_100;

import java.util.HashMap;
import java.util.Map;

public class Temp {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            ans = ans + sumMap.getOrDefault(sum - k, 0) + ((sum - k) == 0 ? 1 : 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
