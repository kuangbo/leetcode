package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/22
 * Time: 下午7:17
 */
public class _1114Foo {
    private volatile int state = 1;

    public _1114Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state = 2;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (state != 2)
                this.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            state = 3;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (state != 3)
                this.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
/*class Foo {
    private AtomicInteger first = new AtomicInteger(0);
    private AtomicInteger second = new AtomicInteger(0);


    public _1114Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (first.get() != 1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (second.get() != 1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}*/
