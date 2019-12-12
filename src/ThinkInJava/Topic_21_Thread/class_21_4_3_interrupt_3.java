package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_4_3_interrupt_3 {
    public static void main(String args[]) throws Exception{
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("use interrupt()");
        t.interrupt();
    }
}
class BlockMutex{
    private Lock lock = new ReentrantLock();

    public BlockMutex(){
        lock.lock();
    }

    public void f(){
        try{
            lock.lockInterruptibly();
            System.out.println("get lock in f()");
        }catch(InterruptedException e) {
            System.out.println("Interrupted in try");
        }
    }
}
class Blocked2 implements Runnable{
    BlockMutex b = new BlockMutex();
    @Override
    public void run() {
        System.out.println("waiting for f() in BlockMutex");
        b.f();
        System.out.println("broken out of bloecked call");
    }
}
