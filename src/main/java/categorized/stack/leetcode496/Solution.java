package categorized.stack.leetcode496;

import java.util.*;

/**
 * 496. 下一个更大元素 I
 * https://leetcode.cn/problems/next-greater-element-i/description/
 */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                Integer pop = stack.pop();
                resultMap.put(pop, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = resultMap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
