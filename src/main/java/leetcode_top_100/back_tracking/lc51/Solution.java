package leetcode_top_100.back_tracking.lc51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N 皇后
 * https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<Integer> columns = new ArrayList<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();

        List<List<String>> ansList = new ArrayList<>();
        dfs(n, 0, columns, diagonal1, diagonal2, ansList);
        return ansList;
    }

    private void dfs(int n, int row, List<Integer> columns, Set<Integer> diagonal1, Set<Integer> diagonal2, List<List<String>> ans) {
        if (row == n) {
            ans.add(genAns(n, columns));
            return;
        }
        for (int column = 0; column < n; column++) {
            if (columns.contains(column)) {
                continue;
            }
            if (diagonal1.contains(row + column)) {
                continue;
            }
            if (diagonal2.contains(row - column)) {
                continue;
            }
            columns.add(column);
            diagonal1.add(row + column);
            diagonal2.add(row - column);
            dfs(n, row + 1, columns, diagonal1, diagonal2, ans);
            columns.remove(columns.size() - 1);
            diagonal1.remove(row + column);
            diagonal2.remove(row - column);
        }
    }

    private List<String> genAns(int n, List<Integer> columns) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int columnPosition = columns.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == columnPosition) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
