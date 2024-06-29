package categorized.recursion.leetcode394;

import java.util.Stack;

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/
 * todo review
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "3[a]2[bc]efef";
        test = "3[a2[c]]efef";
        //test = "2[acb]3[cd]ef";
        //test = "abc3[cd]xyz";
        //test = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        // 3[z]2[ 2[y] pq 4[ 2[jk] e 1[f] ] ]ef
        // zzz yypq jkjkef jkjkef jkjkef jkjkef yypq jkjkef jkjkef jkjkef jkjkef ef
        // zzz yypq jkjkef jkjkef jkjkef jkjkef yypq jkjkef jkjkef jkjkef jkjkef ef
        // zzz yypq jkjkef jkjkef jkjkef jkjkef yypq jkjkef jkjkef jkjkef jkjkef
        String result = solution.decodeString2(test);
        System.out.println(result);
    }

    // todo 有问题
    public String decodeString2(String s) {
        return decodeStringRecursion(s)[1];
    }

    public String[] decodeStringRecursion(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{null, s};
        }
        // 存放非数字字符
        Stack<Character> stack1 = new Stack<>();
        // 存放数字字符
        Stack<Character> stack2 = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                break;
            }
            if (c == ']') {
                return new String[]{i + "", s.substring(0, i)};
            }
            if (Character.isDigit(c)) {
                stack2.push(c);
            } else {
                stack1.push(c);
            }
            i++;
        }
        StringBuilder normalStringSb = new StringBuilder();
        while (!stack1.isEmpty()) {
            normalStringSb.insert(0, stack1.pop());
        }

        StringBuilder numberStringSb = new StringBuilder();
        while (!stack2.isEmpty()) {
            numberStringSb.insert(0, stack2.pop());
        }
        String numberString = numberStringSb.toString();
        int number = numberStringSb.length() == 0 ? 0 : Integer.parseInt(numberString);

        String leftString = (i + 1) >= s.length() ? "" : s.substring(i + 1);
        String[] res = decodeStringRecursion(leftString);
        int index = Integer.parseInt(res[0]);
        i = i + index + 1 + 1;
        String repeatString = res[1];
        while (number > 0) {
            normalStringSb.append(repeatString);
            number--;
        }
        res = decodeStringRecursion(i >= s.length() ? "" : s.substring(i));
        i = Integer.parseInt(res[0] == null ? "0" : res[0]);
        normalStringSb.append(res[1]);
        return new String[]{s.length() + "", normalStringSb.toString()};
    }

    public String decodeString3(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(s.charAt(i));
            i++;
        }
        return new String[]{res.toString()};
    }

}
