package uncategorized.leetcode29;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 思路：
 * 1. 由于int的取值范围为：-2147483648~2147483647 [-2^31~2^31-1]，所以在负数数量要比正数多一个
 * 如果在都转换成正数进行计算-2147483648无法取取绝对值，导致无法处理，所以需要全都转换成负数处理，最后通过通过除数被除数符号处理result符号
 * 2. 通过位移可以将除数扩大2的n次倍，可以快速逼近被除数
 */
public class Divide_Origin {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        //^位异或运算 相同则为0，不相同则为1
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int result = 0;
        while (dividend <= divisor) {
            int divisorCopy = divisor;
            int moveCount = 0;
            while (dividend <= (divisorCopy << 1)) {
                if (divisorCopy <= (Integer.MIN_VALUE >> 1)) break;
                divisorCopy = divisorCopy << 1;
                moveCount = moveCount + 1;
            }
            dividend = dividend - divisorCopy;
            result = result + (-1 << moveCount);
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }

}
