package categorized.heap.lc1046;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1046. 最后一块石头的重量
 * https://leetcode.cn/problems/last-stone-weight/description/
 */
public class Solution {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int value : stones) {
            queue.offer(value);
        }
        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            int result = a - b;
            if (result != 0) {
                queue.offer(result);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
