package leetcode_top_100.heap.lc215;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }
        int ans = 0;
        for (int i = 0; i < k; i++){
            ans = queue.poll();
        }
        return ans;
    }
}
