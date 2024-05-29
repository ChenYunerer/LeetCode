package basicalgorithm.graph.lc827;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827. 最大人工岛
 * https://leetcode.cn/problems/making-a-large-island/description/
 */
public class Solution {


    public static void main(String[] args) {
        int[][] req = new int[][]{{1}};
        int result = new Solution().largestIsland(req);
        System.out.println(result);
    }

    public int largestIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;

        boolean[][] visitedGrid = new boolean[rows][columns];
        int maxArea = 0;
        // 实际岛屿下标从1开始
        int islandIndex = 0;
        Map<Integer, Integer> islandIndexAndArea = new HashMap<>();
        islandIndexAndArea.put(0, 0);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 1 && !visitedGrid[row][column]) {
                    islandIndex = islandIndex + 1;
                    int curArea = dfs(grid, visitedGrid, row, column, islandIndex);
                    islandIndexAndArea.put(islandIndex, curArea);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        if (maxArea < rows * columns) {
            maxArea = maxArea + 1;
        }
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 0) {
                    int curArea = 1;
                    Set<Integer> addedIslandIndex = new HashSet<>();
                    if (row - 1 >= 0) {
                        int index = -grid[row - 1][column];
                        if (!addedIslandIndex.contains(index)) {
                            curArea += islandIndexAndArea.get(index);
                            addedIslandIndex.add(index);
                        }
                    }
                    if (row + 1 < rows) {
                        int index = -grid[row + 1][column];
                        if (!addedIslandIndex.contains(index)) {
                            curArea += islandIndexAndArea.get(index);
                            addedIslandIndex.add(index);
                        }
                    }
                    if (column - 1 >= 0) {
                        int index = -grid[row][column - 1];
                        if (!addedIslandIndex.contains(index)) {
                            curArea += islandIndexAndArea.get(index);
                            addedIslandIndex.add(index);
                        }
                    }
                    if (column + 1 < columns) {
                        int index = -grid[row][column + 1];
                        if (!addedIslandIndex.contains(index)) {
                            curArea += islandIndexAndArea.get(index);
                            addedIslandIndex.add(index);
                        }
                    }
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visitedGrid, int row, int column, int islandIndex) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return 0;
        }
        if (visitedGrid[row][column]) {
            return 0;
        }
        if (grid[row][column] != 1) {
            return 0;
        }
        grid[row][column] = -islandIndex;
        visitedGrid[row][column] = true;
        int ans = 1;
        ans = ans + dfs(grid, visitedGrid, row - 1, column, islandIndex);
        ans = ans + dfs(grid, visitedGrid, row + 1, column, islandIndex);
        ans = ans + dfs(grid, visitedGrid, row, column - 1, islandIndex);
        ans = ans + dfs(grid, visitedGrid, row, column + 1, islandIndex);
        return ans;
    }
}
