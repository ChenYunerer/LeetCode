package categorized.sort.lc215;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 */
public class Solution {

    public static void main(String[] args) {
        int ans = new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(ans);
    }

    private int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }
        int x = nums[left];
        int newLeft = left;
        int newRight = right;
        while (newLeft < newRight) {
            do {
                newLeft++;
            } while (nums[newLeft] < x);
            do {
                newRight--;
            } while (nums[newRight] > x);
            if (newLeft < newRight) {
                int tmp = nums[newLeft];
                nums[newLeft] = nums[newRight];
                nums[newRight] = tmp;
            }
        }
        if (k <= newRight) {
            return quickselect(nums, left, newRight, k);
        } else {
            return quickselect(nums, newRight + 1, right, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }
}
