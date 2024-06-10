package leetcode_top_100.binary_search.lc74;

/**
 * 74. 搜索二维矩阵
 * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int allCount = rows * columns;
        int left = 0;
        int right = allCount - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / columns;
            int column = mid % columns;
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
