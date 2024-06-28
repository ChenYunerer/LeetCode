package basicalgorithm.leetcode.leetcode1423;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 思路：
 * 数组cardPoints长度为n，由于只能从开头和结尾拿k张牌，所以剩下的必然是现连续的k-n张排
 * 所以只要求出剩余卡牌总和最小值，就可以求出拿走卡牌的最大值。
 * 这个思路是我原本的思路刚好相反。
 */
public class MaxScore_1 {

    public static void main(String[] args) {
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
