package leetcode_top_100.back_tracking.lc17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> keyMap = new HashMap<>();
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        dfs(keyMap, digits.toCharArray(), 0, new StringBuffer(), ans);
        return ans;
    }

    private void dfs(Map<Character, String> keyMap, char[] digitsArray, int deep, StringBuffer path, List<String> ans) {
        if (digitsArray.length == deep) {
            ans.add(path.toString());
            return;
        }
        char curChar = digitsArray[deep];
        String valueStr = keyMap.get(curChar);
        for (char ch : valueStr.toCharArray()) {
            dfs(keyMap, digitsArray, deep + 1, path.append(ch), ans);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = new Solution().letterCombinations("23");
        System.out.printf(ans.toString());
    }
}
