package basicalgorithm.recursion.leetcode1922;

/**
 * 1922. 统计好数字的数目
 * https://leetcode.cn/problems/count-good-numbers/
 * todo 还不对，对于n=50就是过不了，思路没问题，对于取余有问题
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // n 50 except 564908303
        int result = solution.countGoodNumbers(50);
        System.out.println(result);
    }

    //public int countGoodNumbers(long n) {
    //    int k = 1000000007;
    //    int result = doCountGoodNumbers(n);
    //    return result % k;
    //}

    public int countGoodNumbers(long n) {
        // 帮帮孩子 %k 放哪里都不对 n=50就是过不了
        int k = 1000000007;
        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 5 * 4;
        }
        return countGoodNumbers(n / 2) * countGoodNumbers(n - (n / 2));
    }
}
