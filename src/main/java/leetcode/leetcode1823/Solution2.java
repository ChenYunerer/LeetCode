package leetcode.leetcode1823;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */
public class Solution2 {


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int result = solution.findTheWinner(5, 2);
        System.out.println(result);
    }

    /**
     * 通过队列进行模拟
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int i = 1;
        while (i <= n) {
            queue.offer(i);
            i++;
        }
        while (queue.size() != 1) {
            int mK = 1;
            while (mK <= k) {
                if (mK == k) {
                    queue.poll();
                } else {
                    queue.offer(queue.poll());
                }
                mK++;
            }
        }
        return queue.poll();
    }
}
