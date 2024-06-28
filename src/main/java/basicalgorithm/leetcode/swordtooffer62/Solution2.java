package basicalgorithm.leetcode.swordtooffer62;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * todo review https://leetcode.cn/circle/article/BOoxAL/
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int result = solution.lastRemaining(6, 7);

        System.out.println(result);
    }


    public int lastRemaining(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
