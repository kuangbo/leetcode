package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/27
 * Time: 下午8:33
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
        //         2, 5, 100L,
        //         TimeUnit.MILLISECONDS,
        //         new LinkedBlockingDeque<>(5),
        //         Executors.defaultThreadFactory(),
        //         new ThreadPoolExecutor.CallerRunsPolicy());
        // for (int request = 0; request < 100; request++) {
        //     int finalRequest = request;
        //     threadPoolExecutor.execute(() -> System.out.println("开始执行" + finalRequest));
        //     try {
        //         Thread.sleep(1L);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     System.out.println("结束执行" + finalRequest);
        // }
        // int i = 1;
        // i = ++i;
        // System.out.println(i);
        // System.out.println(i);
        // i = 1;
        // int j = i++;
        // System.out.println(j);
        // System.out.println(i);
        // i = 2;
        // int k = i + i++ * i++;
        // System.out.println(i);
        // System.out.println(k);
        int[] arr = new int[]{16, 7, 3, 20, 17, 8};
        // quickSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        heapSort(arr);
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

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
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

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void heapSort(int[] arr) {
        // 构建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("------------------------------------------");
        // 将堆顶元素与末尾元素交换，将最大元素放在数组末端
        // 重新调整结构，满足堆的定义，然后继续交换堆顶元素和末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            System.out.println("############################################");
            System.out.println(Arrays.toString(arr));
            adjustHead(arr, 0, j);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void adjustHead(int[] arr, int i, int length) {
        // 暂存当前值
        int temp = arr[i];
        // k = i * 2 + 1 k是i的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {    // 说明左子节点的值小于右子节点的值
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
}
