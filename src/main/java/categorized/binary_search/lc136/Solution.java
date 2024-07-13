package categorized.binary_search.lc136;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/description/
 */
public class Solution {

    /**
     * 异或
     * <p>
     * 异或的性质
     * 自反性：a ^ a = 0
     * 单位元：a ^ 0 = a
     * 交换律：a ^ b = b ^ a
     * 结合律：a ^ (b ^ c) = (a ^ b) ^ c
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
