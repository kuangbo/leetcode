package offer_jianzhi;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/14
 * Time: 下午12:45
 */
public class _offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int item : pushed) {
            stack.push(item);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
