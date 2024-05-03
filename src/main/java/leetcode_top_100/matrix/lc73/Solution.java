package leetcode_top_100.matrix.lc73;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    cols.add(i);
                    rows.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cols.contains(i) || rows.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
