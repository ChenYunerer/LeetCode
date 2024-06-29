package categorized.recursion.leetcode779;

/**
 * 779. 第K个语法符号
 * https://leetcode.cn/problems/k-th-symbol-in-grammar/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.kthGrammar(3, 1);
        System.out.println(result);
    }

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        // 该行数字总数
        int numberCount = (int) Math.pow(2, n - 1);
        // 该行数字总数的一半
        int halfNumberCount = numberCount / 2;
        // 是否是前半部分数字
        boolean headHalfPart = k <= (numberCount / 2);
        int result = kthGrammar(n - 1, (k % halfNumberCount != 0) ? (k % halfNumberCount) : halfNumberCount);
        return headHalfPart ? result : (result == 0 ? 1 : 0);
    }
}
