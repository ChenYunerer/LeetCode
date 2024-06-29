package uncategorized.leetcode978;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
public class MaxTurbulenceSize {

    public static void main(String[] args) {
        int[] arr = new int[]{
                9, 4, 2, 10, 7, 8, 8, 1, 9
        };
        System.out.println(maxTurbulenceSize(arr));
    }

    public static int maxTurbulenceSize(int[] arr) {
        //todo 边界处理 等于处理
        int right = -1;
        int left = -1;
        Boolean greatOrLess = null;
        int ret = 0;
        int maxRet = 0;
        for (int i = 0; i < arr.length; i++) {
            right++;
            if (greatOrLess == null) {
                if (right - 1 < 0) {
                    continue;
                }
                greatOrLess = arr[right] > arr[right - 1];
            } else {
                if (greatOrLess == (arr[right] > arr[right - 1])) {
                    ret = right - left - 1;
                    maxRet = Math.max(maxRet, ret);
                    right = i - 1;
                    left = i - 1;
                    greatOrLess = null;
                }
            }

        }
        return maxRet;
    }
}
