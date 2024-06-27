package leetcode_top_150.double_point.lc392;

/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                if (sIndex == s.length() - 1) {
                    return true;
                }
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return false;
    }
}
