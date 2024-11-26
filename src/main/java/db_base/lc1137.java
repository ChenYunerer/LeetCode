package db_base;

/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode.cn/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc1137 {

    public int tribonacci(int n) {
        int a = 0, b = 0, c = 1, d = 1;
        for (int i = 0; i <= n; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }
}
