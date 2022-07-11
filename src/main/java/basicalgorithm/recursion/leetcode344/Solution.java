package basicalgorithm.recursion.leetcode344;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/
 * todo
 */
public class Solution {
    public void reverseString(char[] s) {
        doReverseString(s, 0, s.length - 1);
    }

    public void doReverseString(char[] s, int p, int q) {
        if (p < q) {
            char temp = s[p];
            s[p] = s[q];
            s[q] = temp;
            doReverseString(s, ++p, --q);
        }
    }
}
