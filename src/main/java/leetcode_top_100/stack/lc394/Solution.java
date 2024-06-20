package leetcode_top_100.stack.lc394;

import java.util.Stack;

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public static void main(String[] args) {
        String ans = new Solution().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(ans);
    }

    public String decodeString(String s) {
        int index = 0;
        Stack<String> stack = new Stack<>();
        while (index < s.length()) {
            Character curChar = s.charAt(index);
            if (Character.isDigit(curChar)) {
                StringBuffer digitSb = new StringBuffer();
                while (Character.isDigit(s.charAt(index))) {
                    digitSb.append(s.charAt(index));
                    index++;
                }
                stack.push(digitSb.toString());
            } else if (Character.isLetter(curChar) || curChar == '[') {
                stack.push(String.valueOf(curChar));
                index++;
            } else {
                // 遇到']'
                StringBuffer encodedSb = new StringBuffer();
                while (!stack.peek().equals("[")) {
                    encodedSb.insert(0, stack.pop());
                }
                String encodedStr = encodedSb.toString();
                // 把[弹出
                stack.pop();
                // 把数字弹出
                String digitStr = stack.pop();
                Integer digit = Integer.parseInt(digitStr);
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < digit; i++) {
                    sb.append(encodedStr);
                }
                stack.push(sb.toString());
                index++;
            }
        }
        StringBuffer ans = new StringBuffer();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}
