package leetcode_top_100.back_tracking.lc79;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        if (rows * columns < word.length()) {
            return false;
        }
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][columns];
                    boolean ans = dfs(board, visited, word, "", row, column);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, String path, int row, int column) {
        if (word.length() == path.length() && path.equals(word)) {
            return true;
        }
        if (path.length() > word.length()) {
            return false;
        }
        int rows = board.length;
        int columns = board[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }
        if (!word.startsWith(path + board[row][column])) {
            return false;
        }
        visited[row][column] = true;
        path = path + board[row][column];
        boolean res = dfs(board, visited, word, path, row - 1, column);
        res = res || dfs(board, visited, word, path, row + 1, column);
        res = res || dfs(board, visited, word, path, row, column - 1);
        res = res || dfs(board, visited, word, path, row, column + 1);
        visited[row][column] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        boolean ans = new Solution().exist(board, "cdba");
        System.out.println(ans);
    }

}
