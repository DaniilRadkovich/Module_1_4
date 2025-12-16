import java.util.concurrent.CountDownLatch;

public class Foo {
    CountDownLatch isDone1 = new CountDownLatch(1);
    CountDownLatch isDone2 = new CountDownLatch(1);
    CountDownLatch isDone3 = new CountDownLatch(1);

    public void first() throws InterruptedException {
        System.out.print("first");
        isDone1.countDown();
    }

    public void second() throws InterruptedException {
        isDone1.await();
        System.out.print("second");
        isDone2.countDown();
    }

    public void third() throws InterruptedException {
        isDone2.await();
        System.out.print("third");
        isDone3.countDown();

    }

    public void fourth() throws InterruptedException {
        isDone3.await();
        System.out.print("fourth");
    }
}