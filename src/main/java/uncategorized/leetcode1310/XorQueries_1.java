package uncategorized.leetcode1310;

/**
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 * 前缀和
 */
public class XorQueries_1 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] sums = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            sums[i] = sums[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = sums[start] ^ sums[end + 1];
        }
        return result;
    }
}
