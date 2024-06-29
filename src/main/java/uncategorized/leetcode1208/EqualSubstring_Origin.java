package uncategorized.leetcode1208;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * 思路：
 * 滑动窗口，每次右端点先向右滑动一格，计算当前窗口的sum cost(add new cost)，判断是否超过max cost
 * 如果超过则滑动窗口则左端点向右滑动一格，计算当前窗口sum cost(delete old cost)
 * 循环以上逻辑直到右端点滑动到最后一格，返回窗口长度
 */
public class EqualSubstring_Origin {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 1;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int left = -1;
        int right = -1;
        int cost = 0;
        while (right < sChars.length - 1) {
            right++;
            cost = cost + Math.abs(sChars[right] - tChars[right]);
            if (cost > maxCost) {
                left++;
                cost = cost - Math.abs(sChars[left] - tChars[left]);
            }
        }
        return right - left;
    }
}
