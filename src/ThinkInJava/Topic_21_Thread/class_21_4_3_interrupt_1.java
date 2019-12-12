package ThinkInJava.Topic_21_Thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_4_3_interrupt_1 {
    static ThreadPoolExecutor exec =(ThreadPoolExecutor) Executors.newCachedThreadPool();

    public static void main(String args[]) {
        try{
            test(new SleepBlockedThread());
            test(new IOBlockedThread(System.in));
            test(new SynBlockedThread());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("close system.in");      System.in.close();
            System.out.println("going to system.exit in Main");
        }catch(Exception e) {
            e.printStackTrace();
        }
//        System.exit(1);
    }
    
    public static void test(Runnable $r) throws Exception{
        Thread t = new Thread($r);
        Future<?> f = exec.submit(t);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("begin to interrupt "+ $r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupted has send to "+ t.getClass().getName());
    }
}

class SleepBlockedThread implements Runnable{
    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(100);
        }catch(InterruptedException e) {
            System.out.println("sleep was interrupted");
        }
        System.out.println("Exit sleepBlockedThread");
    }
}

class IOBlockedThread implements Runnable{
    private InputStream in;
    public IOBlockedThread(InputStream in) {
        this.in = in;
    }
    @Override
    public void run() {
        try{
            System.out.println("waiting for read()");
            in.read();
        }catch(IOException e) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked IO,isInterrupted() is "+Thread.currentThread().isInterrupted());
            }else{
                throw new RuntimeException(e);
            }
        }
        System.out.println("exiting IOBlocked.run()");
    }
}

class SynBlockedThread implements Runnable{
    public SynBlockedThread(){
        new Thread(){
            @Override
            public void run() {
                System.out.println("new Thread() call f()");
                f();     
            }
        }.start();
    }
    
    private synchronized void f(){
        System.out.println("this is f(): begin while");
        while(true) {
            Thread.yield();
        }
    }
    @Override
    public void run() {
        try{
            System.out.println("SynBlockedThread.run():try to call f() ");
            f();   
            System.out.println("SynBlockedThread.run():call f() success");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
