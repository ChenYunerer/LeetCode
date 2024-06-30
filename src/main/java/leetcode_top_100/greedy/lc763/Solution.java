package leetcode_top_100.greedy.lc763;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> ans = new Solution().partitionLabels("eccbbbbdec");
        System.out.println(JSON.toJSONString(ans));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i <= endIndex) {
                int lastIndex = s.lastIndexOf(s.charAt(i));
                endIndex = Math.max(endIndex, lastIndex);
            } else {
                ans.add(endIndex - startIndex + 1);
                startIndex = i;
                int lastIndex = s.lastIndexOf(s.charAt(i));
                endIndex = lastIndex;
            }
        }
        ans.add(endIndex - startIndex + 1);
        return ans;
    }

    /**
     * best
     */
    public List<Integer> partitionLabels1(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
