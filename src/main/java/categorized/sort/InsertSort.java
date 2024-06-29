package categorized.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{
                3, 5, 6, 3, 8, 5, 3, 7, 2, 0, 5, 9, 3, 1, 0
        };
        int[] b = insertSort(a);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 插入排序
     */
    public static int[] insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int key = a[i];
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

}
