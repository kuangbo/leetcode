package test;

import java.util.function.IntConsumer;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/22
 * Time: 下午7:37
 */
public class _1116ZeroEvenOdd {
    private volatile int state = 0;
    private int zeroValue = 2;
    private int oddValue = 1;
    private int evenValue = 2;
    private int n;

    public _1116ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (state != 0)
                this.wait();
            printNumber.accept(0);
            zeroValue = zeroValue == 1 ? 2 : 1;
            state = zeroValue;
            this.notifyAll();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (oddValue <= n) {
                while (state != 1)
                    this.wait();
                printNumber.accept(oddValue);
                oddValue = oddValue + 2;
                state = 0;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (evenValue <= n) {
                while (state != 2)
                    this.wait();
                printNumber.accept(evenValue);
                evenValue = evenValue + 2;
                state = 0;
                this.notifyAll();
            }
        }
    }
}
