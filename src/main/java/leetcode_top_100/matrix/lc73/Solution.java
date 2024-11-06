package leetcode_top_100.matrix.lc73;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().setZeroes1(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

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

    public void setZeroes1(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean firstColumn = false;
        boolean firstRow = false;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] == 0) {
                    if (row == 0) {
                        firstRow = true;
                    }
                    if (column == 0) {
                        firstColumn = true;
                    }
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }
        if (firstRow) {
            for (int column = 0; column < columns; column++) {
                matrix[0][column] = 0;
            }
        }
        if (firstColumn) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }

}
