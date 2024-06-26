package categorized.recursion.leetcode509;

/**
 * 509. 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/
 */
public class Solution {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
