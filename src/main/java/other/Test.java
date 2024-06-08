package other;

public class Test {

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    public static int test(int[] nums) {
        int length = nums.length;
        int[] sumArr = new int[length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            sumArr[i] = sum;
        }
        for (int i = 0; i < sumArr.length; i++) {
            int leftSum = sumArr[i];
            int rightSum = (i + 1 < length) ? (sumArr[length - 1] - sumArr[i + 1]) : 0;
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int ans = test(nums);
        System.out.println(ans);
    }
}
