
/**
 * https://leetcode-cn.com/problems/sliding-window-median/
 * 思路：
 * 维护一个滑动窗口，窗口内部的数据有序
 * 添加或删除元素到时间窗口时，通过处理让窗口内部数据有序
 * 当窗口内数据长度等于k时，进行中位数计算：window[size / 2] * 1.0 / 2 + window[(size - 1) / 2] * 1.0 / 2
 * 在进行中位数计算是需要考虑到int越界问题，所以都是先除以2之后在进行相加，避免int越界
 * size 偶，size / 2 和 (size - 1) / 2为不同数，如果是奇数则是同一个数，避免对于奇偶逻辑判断
 */
public class MedianSlidingWindow_1 {

    public static void main(String[] args) {
        //int[] nums = new int[]{
        //        2147483647,2147483647
        //
        //};
        int[] nums = new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        };
        int k = 3;
        double[] result = medianSlidingWindow(nums, k);
        for (double item : result) {
            System.out.println(item);
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        MidWindow window = new MidWindow(nums.length, k);

        for (int i = 0; i < nums.length; i++) {
            window.getMedianValue(nums[i], i - k >= 0 ? nums[i - k] : null);
        }

        return window.getMidValues();
    }

    static class MidWindow {

        private final int[] window;
        private final double[] midValues;
        private final int k;
        private int size;
        private int index = 0;

        public MidWindow(int length, int k) {
            this.k = k;
            size = 0;
            index = 0;
            midValues = new double[length - k + 1];
            window = new int[k + 1];
        }

        private void remove(int value) {
            int i = 0;
            while (i < size && window[i] != value) {
                i++;
            }
            while (i < size) {
                window[i] = window[i + 1];
                i++;
            }
            size--;
        }

        private void add(int value) {
            int i = 0;
            while (i < size && window[i] < value) {
                i++;
            }
            int j = size;
            while (j - 1 >= i) {
                window[j] = window[j - 1];
                j--;
            }
            window[i] = value;
            size++;
        }

        public void getMedianValue(Integer add, Integer delete) {
            if (delete != null) {
                remove(delete);
            }
            add(add);
            if (size < k) {
                return;
            }
            midValues[index++] = window[size / 2] * 1.0 / 2 + window[(size - 1) / 2] * 1.0 / 2;
        }

        public double[] getMidValues() {
            return midValues;
        }
    }
}
