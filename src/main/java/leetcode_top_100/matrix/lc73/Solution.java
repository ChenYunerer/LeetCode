package leetcode_top_100.matrix.lc73;

/**
 * 73. 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

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
