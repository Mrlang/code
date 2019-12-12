package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mr_liang on 2017/2/18.
 */
public class class_21_2_6 {
    public static void main(String args[]){
        ExecutorService ser = Executors.newCachedThreadPool();
        for(int i=0; i< 5; i++) {
            ser.execute(new Thread(new pritest()));
        }
        for(int i=0; i< 5; i++) {
            Thread thread = new Thread(new pritest(Thread.MIN_PRIORITY));
//            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
        for(int i=0; i< 5; i++) {
            Thread thread = new Thread(new pritest(Thread.MAX_PRIORITY));
//            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }
//        try{
//            Thread.sleep(3000);
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        ser.execute(new pritest());
        ser.shutdown();

    }
}

class pritest implements Runnable {
    private int a;
    public pritest() {

    }
    public pritest(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(a);
        while(true) {
            System.out.println(Thread.currentThread() + "this is priTest Thread");
            Thread.yield();
        }
    }
}