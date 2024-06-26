package leetcode_top_150.array_string.lc88;

/**
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = 0;
        int nums2Index = 0;
        int[] sortedNums = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (nums1Index < m && nums2Index < n) {
                if (nums1[nums1Index] <= nums2[nums2Index]) {
                    sortedNums[i] = nums1[nums1Index++];
                } else {
                    sortedNums[i] = nums2[nums2Index++];
                }
            } else {
                sortedNums[i] = nums1Index < m ? nums1[nums1Index++] : nums2[nums2Index++];
            }
        }
        if (m + n >= 0) System.arraycopy(sortedNums, 0, nums1, 0, m + n);
    }
}
