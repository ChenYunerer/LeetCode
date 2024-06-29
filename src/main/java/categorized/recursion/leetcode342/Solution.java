package categorized.recursion.leetcode342;

/**
 * 342. 4的幂
 * https://leetcode.cn/problems/power-of-four/
 */
public class Solution {

    public boolean isPowerOfFour(int n) {
        return n == 1 || (n != 0 && (n % 4 == 0) && isPowerOfFour(n / 4));
    }
}
