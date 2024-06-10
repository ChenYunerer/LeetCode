package leetcode_top_100.stack.lc20;


import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public static void main(String[] args) {
        Object ans = new Solution().isValid("()[]{}");
        System.out.println(ans);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c - '(' == 0 || c - '{' == 0 || c - '[' == 0) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c - ')' == 0 && stack.pop() - '(' != 0) {
                return false;
            } else if (c - '}' == 0 && stack.pop() - '{' != 0) {
                return false;
            } else if (c - ']' == 0 && stack.pop() - '[' != 0) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
