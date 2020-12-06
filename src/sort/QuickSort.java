package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/12/2
 * Time: 下午5:05
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7, 5, 43, 1, 8};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort2(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int left = l;
        int right = r;
        int key = arr[left];
        while (left < right) {
            while (left < right && key <= arr[right]) {
                --right;
            }
            arr[left] = arr[right];
            while (left < right && key >= arr[left]) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort2(arr, l, left - 1);
        quickSort2(arr, right + 1, r);
    }

    public static void quickSort3(int[] arr, int l, int r) {
        if (l > r)
            return;
        int left = l;
        int right = r;
        int p = arr[left];
        int i = left + 1;
        while (i <= right) {
            if (arr[i] < p) {
                swap(arr, i, left + 1);
                ++i;
                ++left;
            } else if (arr[i] > p) {
                swap(arr, i, right);
                --right;
            } else {
                ++i;
            }
        }
        swap(arr, left, l);
        quickSort3(arr, l, left - 1);
        quickSort3(arr, right + 1, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
