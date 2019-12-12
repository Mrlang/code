package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Mr_liang on 2017/2/19 using IDEA.
 */
public class class_21_2_14 {
    public static void main(String args[]) {
        Thread a = new thread();
        ExecutorService ser = Executors.newCachedThreadPool(new HandlerThreadFactory());
        ser.execute(a);
        ser.shutdown();
    }

}

class handler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("handle : caught Exception -- "+e);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        System.out.println("factory : create a new thread by Runnable");
        t.setUncaughtExceptionHandler(new handler());
        System.out.println("factory: set handle for new thread");
        return t;
    }
}

class thread extends Thread{
    @Override
    public void run() {
//        setUncaughtExceptionHandler(new handler());
        System.out.println("this is thread");
        System.out.println("thread : handler is " + this.getUncaughtExceptionHandler().getClass().getName());
        throw new RuntimeException();
    }
}