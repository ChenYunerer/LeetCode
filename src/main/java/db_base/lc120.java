package db_base;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode.cn/problems/triangle/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[]{triangle.get(0).get(0)};
        for (int level = 1; level < triangle.size(); level++) {
            int[] tempDp = new int[triangle.get(level).size()];
            for (int index = 0; index < triangle.get(level).size(); index++) {
                int dpValue = Math.min((index < dp.length ? dp[index] : Integer.MAX_VALUE), (index - 1 >= 0 ? dp[index - 1] : Integer.MAX_VALUE))
                        + triangle.get(level).get(index);
                tempDp[index] = dpValue;
            }
            dp = tempDp;
        }
        int min = dp[0];
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
