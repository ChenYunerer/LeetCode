package uncategorized.leetcode643;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 思路：
 * 最大平均数 = 最大sum / k
 * 滑动窗口，每次移动滑动窗口则往窗口内添加item以及删除item
 * 添加和删除分别对应sum的加和减，当窗口长度到达k长度时，开始统计每次滑动之后的最大sum
 * 最后通过maxSum / k 获取最大平均数
 * 注意：
 * int越界情况统计sum的时候直接用double
 */
public class FindMaxAverage_Origin {

    public static void main(String[] args) {
        int[] nums = new int[]{8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
        int k = 93;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i] - ((i - k) >= 0 ? nums[i - k] : 0);
            if (i == 0) {
                sum = nums[i];
            }
            if (i > k - 1) {
                maxSum = Math.max(sum, maxSum);
            } else if (i == k - 1) {
                maxSum = sum;
            }
        }
        return maxSum / k;
    }
}
