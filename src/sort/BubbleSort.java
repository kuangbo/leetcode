package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/2
 * Time: 上午9:57
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 4, 3, 2, 8, 9, 4, 20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
