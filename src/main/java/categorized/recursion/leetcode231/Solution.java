package categorized.recursion.leetcode231;

/**
 * 231. 2 的幂
 * https://leetcode.cn/problems/power-of-two/
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        return n == 1 || (n != 0 && (n % 2 == 0) && isPowerOfTwo(n / 2));
    }
}
