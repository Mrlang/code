package ThinkInJava.Topic_21_Thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ThinkInJava.Topic_14_Reflect.*;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_5_2_notify_all {
    public static void main(String args[]) throws Exception{
        ThreadPoolExecutor exc = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for(int i=0; i< 5; i++) {
            exc.execute(new Task());
        }
        new class_14_2_1();
        exc.execute(new Task2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            ThreadPoolExecutor exec = (ThreadPoolExecutor)Executors.newCachedThreadPool();
            private boolean prod = true;
            @Override
            public void run() {
                if(prod){
                    System.out.println("do notify");
                    Task.b.prod();
                    prod = false;
                }else {
                    System.out.println("do notifyAll");
                    Task.b.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("cancled timer");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.b.prodAll()");
        Task2.b.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("shuting down");
        exc.shutdownNow();
    }
}

class Blocker {
    synchronized void waitingCall(){
        try{
            while(!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + ": finish wait");
            }
        }catch(InterruptedException e) {
            System.out.println(Thread.currentThread()+" : cat exception");
        }
            
    }

    synchronized void prod(){
        notify();
    }

    synchronized void prodAll(){
        notifyAll();
    }
}

class Task implements Runnable{
    static Blocker b = new Blocker();
    @Override
    public void run() {
        System.out.println("Task: "+Thread.currentThread());
        b.waitingCall();
    }
}

class Task2 extends Thread {
    static Blocker b= new Blocker();
    @Override
    public void run() {
        System.out.println("Task2: "+Thread.currentThread());
        b.waitingCall();
    }
}


