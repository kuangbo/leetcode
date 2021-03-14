package offer_jianzhi;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/13
 * Time: 下午6:13
 */
public class _offer_30 {
}
class MinStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.add(x);
        if(s2.isEmpty() || s2.peek() >= x)
            s2.add(x);
    }

    public void pop() {
        if(s1.pop().equals(s2.peek()))
            s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
