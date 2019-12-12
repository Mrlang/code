package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_4_4_interrupt_ed {
    public static void main(String args[]) throws Exception{
        /*int time = 6000;  //设置不同的值,让interrupt在不同地方的调用
        Thread t = new Thread(new BlockedThread3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(time);
        t.interrupt();
        */
        Thread t = new InterTest();
        t.start();
        Thread.sleep(1);
        t.interrupt();
    }
}

class NeedsCleanup {
    private int id;
    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("create object,id is "+id);
    }

    public void clean() {
        System.out.println("clean object, id is "+id);
    }
}

class BlockedThread3 implements Runnable{
    private double d = 0.0;
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()) {
//point1
                    NeedsCleanup n1 = new NeedsCleanup(1);
                    try {
                        System.out.println("first sleep");
                        TimeUnit.SECONDS.sleep(1);
//point2
                        NeedsCleanup n2 = new NeedsCleanup(2);
                        try {
                            System.out.println("do math");
                            for (int i = 1; i < 25000000; i++) {
                                d = d + (Math.PI + Math.E) / d;
                            }
                            System.out.println("finish math");
                        } finally {
                            n2.clean();
                        }

                    } finally {
                        n1.clean();
                    }
            }
            System.out.println("while end,isInterrupted() is "+Thread.currentThread().isInterrupted()+",interrupted() is "+ Thread.interrupted());
        }catch(InterruptedException e) {
            System.out.println("blockedThread: interrupted,isInterrupted() is "+Thread.currentThread().isInterrupted()+",interrupted() is "+ Thread.interrupted());
        }
    }
}

class InterTest extends Thread{
    int d;
    @Override
    public void run() {
        whenNoBlock();
    }

    void whenNoBlock(){
        for(int i=0; i< 230000000; i++) {
            d = d+1;
            System.out.println(i);
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Thread.currentThread().isInterrupted() :"+Thread.currentThread().isInterrupted());
                System.out.println("Thread.interrupted() :"+Thread.interrupted());
                System.out.println("Thread.currentThread().isInterrupted() :"+Thread.currentThread().isInterrupted());
                System.out.println("Thread.interrupted() :"+Thread.interrupted());
                System.exit(22);
            }
        }
    }

    void whenBlock() {
        try {
            try {
                sleep(3);
            } finally {
                System.out.println("Thread.currentThread().isInterrupted() :" + Thread.currentThread().isInterrupted());
                System.out.println("Thread.interrupted() :" + Thread.interrupted());
                System.out.println("Thread.currentThread().isInterrupted() :" + Thread.currentThread().isInterrupted());
                System.out.println("Thread.interrupted() :" + Thread.interrupted());
            }
        } catch (InterruptedException e) {
            System.out.println("Thread.currentThread().isInterrupted() :" + Thread.currentThread().isInterrupted());
            System.out.println("Thread.interrupted() ----:" + Thread.interrupted());
        }
    }
}
