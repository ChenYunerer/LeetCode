package basicalgorithm.recursion.leetcode390;

/**
 * 390. 消除游戏
 * https://leetcode.cn/problems/elimination-game/
 * todo
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int output = solution.lastRemaining(6);
        System.out.println(output);
    }

    public int lastRemaining(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        return lastRemaining(arr, false)[0];
    }

    public int[] lastRemaining(int[] arr, boolean keepEven) {
        if (arr.length == 1) {
            return arr;
        }
        int[] newArr = new int[!keepEven ? (arr.length / 2) : (arr.length / 2 + arr.length % 2)];
        int newArrIndex = 0;
        // index from 0
        for (int i = 0; i < arr.length; i++) {
            // judge i is even number or not
            if (i % 2 == (keepEven ? 0 : 1)) {
                newArr[newArrIndex++] = arr[i];
            }
        }
        return lastRemaining(newArr, !keepEven);
    }
}
