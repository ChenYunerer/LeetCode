package leetcode_top_150.double_point.lc167;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            } else if (sum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return null;
    }
}
