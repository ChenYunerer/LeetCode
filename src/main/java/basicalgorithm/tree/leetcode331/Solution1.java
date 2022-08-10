package basicalgorithm.tree.leetcode331;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化
 * https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Solution1 {

    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        Deque<Integer> deque = new LinkedList<>();
        for (String str : array) {
            deque.offer(str.equals("#") ? null : Integer.parseInt(str));
        }
        Integer firstInt = deque.poll();

        return dfs(firstInt, deque) && deque.isEmpty();
    }

    public boolean dfs(Integer rootVal, Deque<Integer> deque) {
        if (rootVal == null) {
            return true;
        }
        if (deque.isEmpty()) {
            return false;
        }
        Integer leftVal = deque.poll();
        boolean leftValid = dfs(leftVal, deque);

        if (deque.isEmpty()) {
            return false;
        }
        Integer rightVal = deque.poll();
        boolean rightValid = dfs(rightVal, deque);
        return leftValid && rightValid;
    }

}
