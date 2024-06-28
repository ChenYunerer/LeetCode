package leetcode_top_150.stack.lc71;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 71. 简化路径
 * https://leetcode.cn/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {


    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] strArray = path.split("/");
        for (String str : strArray) {
            if (str.isEmpty()) {
                // no nothing
            } else if (str.equals(".")) {
                // no nothing
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuffer = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuffer.append( "/");
            stringBuffer.append(stack.pollLast());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String ans = new Solution().simplifyPath("/a/../../b/../c//.//");
        System.out.println(ans);
    }
}
