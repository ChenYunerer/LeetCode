/**
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 思路：
 * 本题本质还是滑动窗口，使用双指针进行处理
 * 先对源数组进行处理 cardPoints=1,2,3,4,5,6,1 k=3，处理成：[5,6,1] + [1,2,3,4,5,6,1]
 * 然后滑动窗口从头开始滑动即可
 */
public class MaxScore_Origin {

    public static void main(String[] args) {
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int[] newCarPoints = new int[cardPoints.length + k];
        for (int i = 0; i < newCarPoints.length; i++) {
            if (i < k) {
                newCarPoints[i] = cardPoints[cardPoints.length - k + i];
            } else {
                newCarPoints[i] = cardPoints[i - k];
            }
        }
        int left = 0;
        int right = left + k - 1;
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum = sum + newCarPoints[i];
        }
        int maxSum = sum;
        for (int i = 0; i < k; i++) {
            right++;
            sum = sum + newCarPoints[right];
            sum = sum - newCarPoints[left];
            left++;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
