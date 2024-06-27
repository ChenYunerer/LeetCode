package leetcode_top_150.double_point.lc125;

/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            if (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
                continue;
            }
            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new Solution().isPalindrome("0P");
        System.out.println(ans);
    }
}
