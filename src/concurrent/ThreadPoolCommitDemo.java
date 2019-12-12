package concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shixiang@corp.netease.com
 * @date 2019/2/10 10:56 AM
 */
public class ThreadPoolCommitDemo {

    private static ExecutorService pool = new ThreadPoolExecutor(2, 2, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(4),
            Executors.defaultThreadFactory(),
            //自定义了拒绝策略
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println(r.toString() + " is discard");
                }
            });

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition isFull = lock.newCondition();

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " :Thread ID: " + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
                int queueSize = ((ThreadPoolExecutor) pool).getQueue().size();
                if (queueSize < 3) {
                    lock.lock();
                    isFull.signal();
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int queueSize = ((ThreadPoolExecutor) pool).getQueue().size();
            System.out.println("blocking queue size：" + queueSize);
            if (queueSize >= 3) {
                lock.lock();
                try {
                    isFull.await();
                } catch (InterruptedException e) {
                    isFull.signal();
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            pool.execute(new MyTask());
        }
    }
}
