package leetcode_top_100.hash.lc49;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {


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
