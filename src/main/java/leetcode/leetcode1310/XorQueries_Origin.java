package leetcode.leetcode1310;

/**
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 * 暴力解法
 */
public class XorQueries_Origin {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            for (int j = start; j <= end; j++) {
                result[i] = result[i] ^ arr[j];
            }
        }
        return result;
    }
}
