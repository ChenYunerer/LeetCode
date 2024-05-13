package leetcode_top_100.matrix.lc240;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int targetRow = rows - 1, targetColumn = columns - 1;
        for (int row = rows - 1; row >= 0; row--) {
            if (matrix[row][0] == target) {
                return true;
            }
            if (matrix[row][0] < target) {
                targetRow = row;
                break;
            }
        }
        for (int column = columns - 1; column >= 0; column--) {
            if (matrix[0][column] == target) {
                return true;
            }
            if (matrix[0][column] <= target) {
                targetColumn = column;
                break;
            }
        }
        for (int row = 0; row <= targetRow; row++) {
            for (int column = 0; column <= targetColumn; column++) {
                if (matrix[row][column] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] rows : matrix) {
            if (search(rows, target) != -1) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * best
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
