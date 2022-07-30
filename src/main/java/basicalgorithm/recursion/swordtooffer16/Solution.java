package basicalgorithm.recursion.swordtooffer16;

/**
 * 剑指 Offer 16. 数值的整数次方
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Solution {

    public double myPow(double x, int n) {
        boolean nIsNegative = n < 0;
        double result = myPow4PositiveN(x, nIsNegative ? -n : n);
        return nIsNegative ? (1 / result) : result;
    }

    public double myPow4PositiveN(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = (n % 2) == 0;
        double partResult = myPow4PositiveN(x, n / 2);
        return partResult * partResult * (flag ? 1 : x);
    }
}
