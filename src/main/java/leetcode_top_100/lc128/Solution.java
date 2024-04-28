package leetcode_top_100.lc128;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            int tempMax = 1;
            while (set.contains(--num)) {
                tempMax++;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }

    // best
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int tempMax = 1;
            while (set.contains(++num)) {
                tempMax++;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }
}
