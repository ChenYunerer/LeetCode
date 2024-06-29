package categorized.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{
                3, 5, 6, 3, 8, 5, 3, 7, 2, 0, 5, 9, 3, 1, 0
        };
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (a[i] > a[j]) {
                temp[t] = a[j];
                j++;
            } else {
                temp[t] = a[i];
                i++;
            }
            t++;
        }
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= right) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (left <= right) {
            a[left++] = temp[t++];
        }
    }

}
