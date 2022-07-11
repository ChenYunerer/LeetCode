package basicalgorithm.recursion.leetcode394;

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/
 */
public class Solution {

    public String decodeString(String s) {
        if (s == null || !s.contains("[") || !s.contains("]")) {
            return s;
        }
        int p = s.indexOf("[");
        int q = s.lastIndexOf("]");

        return null;
    }
}
