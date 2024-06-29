package leetcode_top_100.greedy.lc121;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    /**
     * 逆向计算
     */
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, max - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 正向计算
     */
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
