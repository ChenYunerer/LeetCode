package leetcode_top_100.matrix.lc48;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int colums = matrix[0].length;
        if (rows == 0 || colums == 0) return;
        int[][] newMatrix = new int[rows][colums];
        for (int row = 0; row < rows; row++) {
            for (int colum = 0; colum < colums; colum++) {
                newMatrix[colum][rows - row - 1] = matrix[row][colum];
            }
        }
        for (int row = 0; row < rows; row++) {
            System.arraycopy(newMatrix[row], 0, matrix[row], 0, colums);
        }
    }
}
