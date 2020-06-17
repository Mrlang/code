package concurrent.SemaphoreTest;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by wangliang01 on 2020/4/22 using IDEA.
 */
public class SemaphoreTestDemo {
    @Test
    public void test() throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        TestTask testTask = new TestTask(semaphore);
        for (int i = 0; i < 5; i++) {
            new Thread(testTask).start();
        }

        System.out.println(semaphore.availablePermits());
        Thread.sleep(6000);
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        Thread.sleep(60000);
    }

    class TestTask implements Runnable{
        Semaphore semaphore;

        public TestTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println(semaphore.availablePermits());
                semaphore.acquire();
                System.out.println("拿到锁" + semaphore.availablePermits());
                //Thread.sleep(new Random().internalNextLong(10000L, 20000L));
                semaphore.release();
                System.out.println("释放锁" + semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
