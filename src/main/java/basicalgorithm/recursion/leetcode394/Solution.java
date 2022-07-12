package basicalgorithm.recursion.leetcode394;

import java.util.Stack;

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/
 */
public class Solution {

    public String decodeString(String s) {
        if (s == null || !s.contains("[") || !s.contains("]")) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar != ']') {
                stack.push(curChar);
            } else {
                StringBuilder repeatStringSb = new StringBuilder();
                while (stack.peek() != '[') {
                    repeatStringSb.insert(0, stack.pop());
                }
                String repeatString = repeatStringSb.toString();

                // 去除[
                stack.pop();

                StringBuilder repeatNumberSb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    repeatNumberSb.insert(0, stack.pop());
                }
                int repeatNum = Integer.parseInt(repeatNumberSb.toString());

                for (int h = 0; h < repeatNum; h++) {
                    for (int j = 0; j < repeatString.length(); j++) {
                        stack.push(repeatString.charAt(j));
                    }
                }
            }
        }
        StringBuilder resultStringSb = new StringBuilder();
        while (!stack.isEmpty()) {
            resultStringSb.insert(0, stack.pop());
        }
        return resultStringSb.toString();
    }

}
