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
        if (intervals == null || intervals.length == 0) return new int[0][2];

        // 将区间按照起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果当前合并后的区间列表为空，或者当前区间的起始位置大于合并后的区间列表中最后一个区间的结束位置
            // 则直接将当前区间添加到合并后的区间列表中
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // 否则，当前区间与合并后的区间列表中最后一个区间有重叠，更新合并后的区间列表中最后一个区间的结束位置
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
