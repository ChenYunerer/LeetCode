package leetcode.swordtooffer62;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.lastRemaining(6, 7);

        System.out.println(result);
    }

    /**
     * 借助队列进行模拟
     * 会超时
     */
    public int lastRemaining(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int i = 0;
        while (i < n) {
            queue.offer(i);
            i++;
        }
        while (queue.size() != 1) {
            int newK = k % queue.size() + (k % queue.size() == 0 ? queue.size() : 0);
            int mK = 1;
            while (mK <= newK) {
                if (mK == newK) {
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
