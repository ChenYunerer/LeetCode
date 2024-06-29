package uncategorized.lc2710;

/**
 * 2710. 移除字符串中的尾随零
 * https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/description/
 */
public class Solution {

    public String removeTrailingZeros(String num) {
        int index = num.length() - 1;
        while (index >= 0) {
            if (num.charAt(index) != '0') {
                break;
            } else {
                index--;
            }
        }
        return num.substring(0, index + 1);
    }
}
