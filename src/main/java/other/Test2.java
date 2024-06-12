package other;

import com.alibaba.fastjson2.JSON;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title
 * 滑动窗口的最大值
 * <p>
 * Question description
 * 输入：数组、窗口大小
 * <p>
 * 举例：
 * 5 5 3 4 6 7 8
 * 大小：3
 * <p>
 * 输出：
 * 5 5 6 7 8
 */
public class Test2 {


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

    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 3, 4, 6, 7, 8};
        int[] as = maxSlidingWindow(nums, 3);
        System.out.println(JSON.toJSONString());
    }
}
