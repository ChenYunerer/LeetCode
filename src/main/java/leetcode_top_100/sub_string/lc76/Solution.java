package leetcode_top_100.sub_string.lc76;

import java.util.Arrays;

public class Solution {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        int[] tCount = new int[26];
        for (char c : t.toCharArray()) {
            tCount[c - 'a']++;
        }
        int[] sCount = new int[26];
        for (int i = 0; i < t.length(); i++) {
            if (tCount[s.charAt(i) - 'a'] > 0) {
                sCount[s.charAt(i) - 'a']++;
            }
        }
        if (Arrays.equals(tCount, sCount)) {
            return s.substring(0, t.length());
        }
        String subStr = s;
        int i = 0;
        int j = t.length();
        for (; j < s.length(); j++) {
            if (tCount[s.charAt(j) - 'a'] > 0) {
                sCount[s.charAt(j) - 'a']++;
            }
            if (Arrays.equals(tCount, sCount)) {
                if (j - i < subStr.length()) {
                    subStr = s.substring(i, j + 1);
                }
            }

        }
        return subStr;
    }
}
