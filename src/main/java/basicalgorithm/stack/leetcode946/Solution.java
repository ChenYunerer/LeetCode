package basicalgorithm.stack.leetcode946;

import java.util.Stack;

/**
 * 946. 验证栈序列
 * https://leetcode.cn/problems/validate-stack-sequences/description/
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int pushedIndex = 0;
        int poppedIndex = 0;
        Stack<Integer> stack = new Stack<>();
        // init stack
        while (pushed[pushedIndex] != popped[0]) {
            stack.push(pushed[pushedIndex++]);
        }
    }
}
