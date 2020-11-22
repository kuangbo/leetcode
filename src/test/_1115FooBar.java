package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/22
 * Time: 下午6:54
 */
public class _1115FooBar {
    private int n;
    private volatile boolean finish = false;

    public _1115FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (finish)
                    this.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                finish = true;
                this.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!finish)
                    this.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                finish = false;
                this.notify();
            }
        }
    }
}
/*
class FooBar {
    private int n;
    private ReentrantLock reentrantLock;
    private Condition condition1;
    private Condition condition2;
    private volatile int state;

    public FooBar(int n) {
        this.n = n;
        this.state = 1;
        this.reentrantLock = new ReentrantLock();
        this.condition1 = reentrantLock.newCondition();
        this.condition2 = reentrantLock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                reentrantLock.lock();
                while (state != 1)
                    condition1.await();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                state = 2;
                condition2.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                reentrantLock.lock();
                while(state != 2)
                    condition2.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                state = 1;
                condition1.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}*/

