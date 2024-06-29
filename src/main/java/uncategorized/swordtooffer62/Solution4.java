package uncategorized.swordtooffer62;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * todo review https://leetcode.cn/circle/article/BOoxAL/
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();

        int result = solution.lastRemaining(6, 7);

        System.out.println(result);
    }

    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
