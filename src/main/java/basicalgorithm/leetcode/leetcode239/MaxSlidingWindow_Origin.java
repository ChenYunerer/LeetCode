package basicalgorithm.leetcode.leetcode239;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 思路：
 * 滑动窗口中的最大值通过优先级队列(大根堆)维护
 * 每次获取队列头部节点就是当前窗口的最大值
 * 问题：
 * todo 超时了 待优化
 */
public class MaxSlidingWindow_Origin {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        };
        int k = 3;
        int[] ret = maxSlidingWindow(nums, k);
        for (int i : ret) {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int[] ret = new int[nums.length - k + 1];
        int retIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i + 1 >= k) {
                if (i + 1 > k) {
                    queue.remove(nums[i - k]);
                }
                ret[retIndex] = queue.peek();
                retIndex++;
            }
        }
        return ret;
    }

}
