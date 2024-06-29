package categorized.recursion.leetcode1922;

/**
 * 1922. 统计好数字的数目
 * https://leetcode.cn/problems/count-good-numbers/
 * todo 还不对，对于n=50就是过不了，思路没问题，对于取余有问题
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // n 50 except 564908303
        long result = solution.doCountGoodNumbers(50);
        System.out.println(result);
    }

    public int countGoodNumbers(long n) {
        int k = 1000000007;
        long result = doCountGoodNumbers(n);
        return (int) (result % k);
    }

    public long doCountGoodNumbers(long n) {
        int k = 1000000007;
        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 5 * 4;
        }
        long part1 = doCountGoodNumbers(n / 2);
        long part2 = doCountGoodNumbers(n - (n / 2));
        long result = ((part1 % k) * (part2 % k)) % k;
        return result;
    }
}
