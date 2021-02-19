package basicalgorithm;

/**
 * 分治法求最大子数组
 */
public class MaxSubArray {

    static Result findMaximumSubarray(int[] A, int low, int high) {
        if (low == high) {
            return new Result(low, high, A[low]);
        } else {
            int mid = (low + high) / 2;
            Result leftResult = findMaximumSubarray(A, low, mid);
            Result rightResult = findMaximumSubarray(A, mid + 1, high);
            Result crossResult = findMaxCrossingSubarray(A, low, mid, high);
            if (leftResult.sum >= rightResult.sum && leftResult.sum >= crossResult.sum)
                return leftResult;
            else if (rightResult.sum >= leftResult.sum && rightResult.sum >= crossResult.sum)
                return rightResult;
            else return crossResult;
        }

    }

    static Result findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        //向左试探
        int leftSum = Integer.MIN_VALUE;   //哨兵
        int maxLeft = mid;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        //向右试探
        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid + 1;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += A[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        //将两边的结果合起来
        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }

    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        Result result = findMaximumSubarray(A, 0, A.length - 1);
        System.out.println(result.low + "," + result.high + " " + result.sum);
    }

    private static class Result {
        int low;
        int high;
        int sum;

        public Result(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }
}
