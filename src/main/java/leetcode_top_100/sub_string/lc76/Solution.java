package leetcode_top_100.sub_string.lc76;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {


    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        String ans = new Solution().minWindow(s, t);
        System.out.println(ans);
    }

    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = -1;
        int ansL = -1;
        int ansR = -1;
        while (right < s.length()) {
            right++;
            if (right < s.length() && tMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (left <= right && checkIsAContainB(sMap, tMap)) {
                if (ansR == -1 || ansR - ansL > right - left) {
                    ansR = right;
                    ansL = left;
                }
                char sLeftC = s.charAt(left);
                sMap.put(sLeftC, sMap.getOrDefault(sLeftC, 0) - 1);
                left++;
            }

        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    public boolean checkIsAContainB(Map<Character, Integer> aMap, Map<Character, Integer> bMap) {
        for (Map.Entry<Character, Integer> entry : bMap.entrySet()) {
            if (entry.getValue() > 0 && aMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
