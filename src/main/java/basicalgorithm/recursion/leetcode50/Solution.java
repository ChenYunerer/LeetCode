package basicalgorithm.recursion.leetcode50;

/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/
 */
public class Solution {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Solution solution = new Solution();
        double x = 0.00001;
        int n = 2147483647;
        double result = solution.myPow(x, n);
        System.out.println(result);
        System.out.println("time consume: " + (System.currentTimeMillis() - startTime));
    }


    /**
     * 分治
     */
    public double myPow(double x, int n) {
        boolean isNegative = n < 0;
        if (isNegative) {
            n = -n;
        }
        double result = myPowForPositiveNumber(x, n);
        if (isNegative) {
            return 1 / result;
        } else {
            return result;
        }
    }

    private double myPowForPositiveNumber(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = n % 2 == 0;
        double result = myPowForPositiveNumber(x, n / 2);
        return result * result * (flag ? 1 : x);
    }

    /**
     * 当n很大时 会栈溢出
     * 这个方式只用了递归，太笨了
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean negative = n < 0;
        return (negative ? (1 / x) : x) * myPow1(x, negative ? (++n) : (--n));
    }
}
