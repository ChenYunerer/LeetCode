public class Divide_Origin {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean positive = (dividend >> 31 ^ divisor >> 31) == 0;
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int result = divide0(absDividend, absDivisor, 0);

        return positive ? result : -result;
    }

    public static int divide0(int dividend, int divisor, int i) {
        if (dividend < divisor) {
            return i;
        }
        int j = 0;
        int divisorCopy = divisor;
        while (dividend > divisorCopy) {
            j++;
            divisorCopy = divisorCopy << 1;
        }
        if (dividend == divisorCopy) {
            return i + 1 << j;
        } else {
            j--;
            divisorCopy = divisorCopy >> 1;
            int newDividend = dividend - divisorCopy;
            if (newDividend < divisor) {
                return i + 1 << j;
            } else {
                return divide0(newDividend, divisor, i + 1 << j);
            }
        }
    }

}
