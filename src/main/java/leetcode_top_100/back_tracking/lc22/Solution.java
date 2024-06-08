package leetcode_top_100.back_tracking.lc22;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        dfs(n, 0, 0, 0, new StringBuffer(), ans);
        return ans;
    }

    private void dfs(int n, int deep, int leftNum, int rightNum, StringBuffer path, List<String> ans) {
        if (deep == 2 * n) {
            ans.add(path.toString());
            return;
        }
        if (leftNum == rightNum) {
            path.append("(");
            dfs(n, deep + 1, leftNum + 1, rightNum, path, ans);
            path.deleteCharAt(path.length() - 1);
        } else {
            if (leftNum + 1 <= n) {
                path.append("(");
                dfs(n, deep + 1, leftNum + 1, rightNum, path, ans);
                path.deleteCharAt(path.length() - 1);
            }
            if (rightNum < leftNum) {
                path.append(")");
                dfs(n, deep + 1, leftNum, rightNum + 1, path, ans);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Object ans = new Solution().generateParenthesis(3);
        System.out.println(JSON.toJSONString(ans));
    }
}
