package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/2
 * Time: 上午10:37
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 2, 6, 8, 20, 5, 6, 90};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        // 构建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, arr.length);
        }
        // 将堆顶元素与末尾元素交换，将最大元素放在数组末端
        // 重新调整结构，满足堆的定义，然后继续交换堆顶元素和末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHead(arr, 0, j);
        }
    }

    public static void adjustHead(int[] arr, int i, int len) {
        // 暂存当前值
        int temp = arr[i];
        // k = i * 2 + 1 k是i的左子节点
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {    // 说明左子节点的值小于右子节点的值
                k++;    // k指向右子节点
            }
            if (arr[k] > temp) {    // 如果子节点大于父节点
                arr[i] = arr[k];    // 把较大的值赋给当前节点
                i = k;  // i指向子节点位置k，继续循环
            } else {
                break;
            }
        }
        // 此时，以i为父节点的树的最大值，放在了顶部
        arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
