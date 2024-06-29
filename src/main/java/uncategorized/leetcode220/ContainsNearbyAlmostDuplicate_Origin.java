package uncategorized.leetcode220;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class ContainsNearbyAlmostDuplicate_Origin {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
