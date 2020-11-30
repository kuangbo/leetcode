package offer_jianzhi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/30
 * Time: 下午1:13
 */
public class _offer_59_2 {
    class MaxQueue {
        private Deque<Integer> queue;   // queue用来记录所有插入元素的值
        private Deque<Integer> help;    // help队列用来维护最大值元素

        public MaxQueue() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public int max_value() {
            // help为最大值队列，如果help为null，返回-1，否则返回队列中的第一个元素
            return help.isEmpty() ? -1 : help.peekFirst();
        }

        public void push_back(int value) {
            // 每次入队的时候，如果help队尾元素小于即将入队的元素value，则将所有小于value的元素全部出队后，再将value入队
            // 否则直接入队
            queue.offer(value);
            while (!help.isEmpty() && help.peekLast() < value) {
                help.pollLast();
            }
            help.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
                return -1;
            int val = queue.poll();
            if (val == help.peekFirst()) {  // 当queue出队元素与help的第一个元素相等的时候，需要同时将help中的第一个元素弹出
                help.pollFirst();
            }
            return val;
        }
    }
}
