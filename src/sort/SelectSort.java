package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/2
 * Time: 上午10:04
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 4, 3, 2, 8, 9, 4, 20};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
