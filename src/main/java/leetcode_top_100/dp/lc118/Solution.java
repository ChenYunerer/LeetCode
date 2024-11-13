package leetcode_top_100.dp.lc118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> level = new ArrayList<>();
            for (int index = 1; index <= i; index++) {
                if (index == 1 || index == i) {
                    level.add(1);
                } else {
                    level.add(ans.get(i - 1 - 1).get(index - 1 - 1) + ans.get(i - 1 - 1).get(index - 1));
                }
            }
            ans.add(level);
        }
        return ans;
    }


    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            for (int index = 0; index <= i; index++) {
                if (index == 0 || index == i) {
                    level.add(1);
                } else {
                    level.add(ans.get(i - 1).get(index - 1) + ans.get(i - 1).get(index));
                }
            }
            ans.add(level);

        }
        return ans;
    }
}
