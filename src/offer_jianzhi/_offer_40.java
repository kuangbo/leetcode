package offer_jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/23
 * Time: 下午1:25
 */
public class _offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] newArr = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            newArr[i] = queue.poll();
        }
        return newArr;
    }
}
