package leetcode_top_100.normal_array.lc56;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ansList.isEmpty() || ansList.get(ansList.size() - 1)[1] < interval[0]) {
                ansList.add(interval);
            } else {
                ansList.get(ansList.size() - 1)[1] = Math.max(ansList.get(ansList.size() - 1)[1], interval[1]);
            }
        }
        int[][] ans = new int[ansList.size()][2];
        return ansList.toArray(ans);
    }

}
