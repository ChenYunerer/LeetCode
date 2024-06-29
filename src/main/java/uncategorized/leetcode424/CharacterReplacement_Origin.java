package uncategorized.leetcode424;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * 思路：
 * 一个可变长度的滑动窗口
 * 对于重复字符的统计直接用int[]标识，index为字符的ascii码 - ‘A’的ascii码
 * 先取前k+1个值，判断最大重复数为n，则预期的最大长度为n+k
 * 然后从n+k处向右移动滑动窗口右端点，再次统计最大滑动窗口长度，如果长度变化则取下一个值，如果没有变化则移动左端点
 * 注意：
 * 计算出的最大滑动窗口大小必须小于字符长度
 * 对于输入字符做空判断
 */
public class CharacterReplacement_Origin {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABDEQADSSAAA", 2));
    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] numOfChar = new int[26];
        int maxOfRepeatChar = k;
        for (int i = 0; i <= k; i++) {
            numOfChar[chars[i] - 'A']++;
            maxOfRepeatChar = Math.min(Math.max(maxOfRepeatChar, k + numOfChar[chars[i] - 'A']), chars.length);
        }
        if (maxOfRepeatChar > s.length()) {
            return s.length();
        }
        for (int i = k + 1; i < chars.length; i++) {
            numOfChar[chars[i] - 'A']++;
            int newMaxOfRepeatChar = Math.min(Math.max(maxOfRepeatChar, k + numOfChar[chars[i] - 'A']), chars.length);
            boolean shouldMoveLeft = newMaxOfRepeatChar == maxOfRepeatChar;
            maxOfRepeatChar = newMaxOfRepeatChar;
            if (shouldMoveLeft && i - maxOfRepeatChar >= 0) {
                numOfChar[chars[i - maxOfRepeatChar] - 'A']--;
                maxOfRepeatChar = Math.min(Math.max(maxOfRepeatChar, k + numOfChar[chars[i - maxOfRepeatChar + 1] - 'A']), chars.length);
            }
        }
        return maxOfRepeatChar;
    }
}
