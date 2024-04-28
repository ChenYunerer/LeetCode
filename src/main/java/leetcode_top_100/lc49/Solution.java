package leetcode_top_100.lc49;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Integer, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.computeIfAbsent(getKey(str), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private Map<Integer, Integer> getKey(String str) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put('a' - str.charAt(i), map.getOrDefault('a' - str.charAt(i), 0) + 1);
        }
        return map;
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }


}
