package leetcode_top_100.sliding_window.lc438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();
        int[] count1 = new int[26];
        for (char c : p.toCharArray()) {
            count1[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        int[] count2 = new int[26];
        while (right <= s.length()) {
            if (right < p.length()) {
                count2[s.charAt(right) - 'a']++;
                right++;
            }
            if (right - left == p.length()) {
                if (Arrays.equals(count1, count2)) {
                    ans.add(left);
                }
                count2[s.charAt(left) - 'a']--;
                left++;
                if (right < s.length()) {
                    count2[s.charAt(right) - 'a']++;
                }
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().findAnagrams("abab", "ab");
    }
}
