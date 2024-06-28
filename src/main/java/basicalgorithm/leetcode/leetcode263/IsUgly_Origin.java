package basicalgorithm.leetcode.leetcode263;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 * 思路：
 * 只要N能不停的整除2，3，5，最后整除后结果为1则是丑数，否则不是
 * 比如一个数N = 2 * 2 * 3 * 5 * 5 * X
 * 只要把所有的2，3，5全部除完，只要判断剩下的X是否是1即可
 * 注意:
 * 0除以任何数都是0，需要做边界判断
 */
public class IsUgly_Origin {

    public static final int[] a = new int[]{2, 3, 5};

    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        for (int i : a) {
            while (n % i == 0) {
                n = n / i;
            }
        }
        return n == 1;
    }
}
