package basicalgorithm.recursion.interview0805;

/**
 * 面试题 08.05. 递归乘法
 * https://leetcode.cn/problems/recursive-mulitply-lcci/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply(3, 4));
    }

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A > B) {
            return A + multiply(A, --B);
        } else {
            return B + multiply(--A, B);
        }
    }


    /**
     * 不完美的写法
     */
    public int multiply1(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        return A + multiply(A, --B);
    }
}
