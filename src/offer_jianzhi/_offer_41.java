package offer_jianzhi;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/12/5
 * Time: 下午4:19
 */
public class _offer_41 {
    class MedianFinder {
        /**
         * initialize your data structure here.
         */
        Queue<Integer> q1, q2;

        public MedianFinder() {
            q1 = new PriorityQueue<>(); // 小顶堆 ，保存较大的一半
            q2 = new PriorityQueue<>((x, y) -> (y - x));    // 大顶堆，保存较小的一半
        }

        public void addNum(int num) {
            if (q1.size() != q2.size()) {
                q1.add(num);
                q2.add(q1.poll());
            } else {
                q2.add(num);
                q1.add(q2.poll());
            }
        }

        public double findMedian() {
            return q1.size() != q2.size() ? q1.peek() : (q1.peek() + q2.peek()) / 2.0;
        }
    }
}
