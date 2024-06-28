package leetcode_top_100.heap.lc347;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int originCount = countMap.getOrDefault(num, 0);
            countMap.put(num, originCount + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index++] = queue.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
