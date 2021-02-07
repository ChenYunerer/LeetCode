package leetcode978;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
public class MaxTurbulenceSize {

    public int maxTurbulenceSize(int[] arr) {
        //todo 边界处理 等于处理
        int right = -1;
        int left = -1;
        Boolean greatOrLess = null;
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            right++;
            ret = right - left;
            if (right - left < 2) {
                continue;
            }
            if (greatOrLess == null) {
                greatOrLess = arr[right] > arr[right - 1];
            } else {
                if (greatOrLess == (arr[right] > arr[right - 1])) {
                    ret--;
                }
            }

        }
    }
}
