package basicalgorithm.recursion.leetcode326;

/**
 * 326. 3 的幂
 * https://leetcode.cn/problems/power-of-three/
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        return n == 1 || (n != 0 && (n % 3 == 0) && isPowerOfThree(n / 3));
    }
}
