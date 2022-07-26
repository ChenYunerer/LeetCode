package basicalgorithm.recursion.swordtooffer64;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode.cn/problems/qiu-12n-lcof/
 */
public class Solution {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n = n + sumNums(--n)) > 0;
        return n;
    }
}
