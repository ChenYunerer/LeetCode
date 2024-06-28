package basicalgorithm.leetcode.swordtooffer62;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * todo review https://leetcode.cn/circle/article/BOoxAL/
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int result = solution.lastRemaining(6, 7);

        System.out.println(result);
    }


    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
