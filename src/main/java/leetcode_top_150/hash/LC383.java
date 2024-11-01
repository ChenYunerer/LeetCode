package leetcode_top_150.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int count = magazineMap.getOrDefault(c, 0);
            if (count <= 0) {
                return false;
            }
            magazineMap.put(c, count - 1);
        }
        return true;
    }
}
