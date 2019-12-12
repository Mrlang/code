package ThinkInJava.Topic_21_Thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Mr_liang on 2017/2/20 using IDEA.
 */
public class class_21_3_4 {
    public static void main(String args[]) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("all right ,system exit");
                System.exit(0);
            }
        }, 5000);

        ExecutorService ser = Executors.newCachedThreadPool();
        ThreadUseAtomic t = new ThreadUseAtomic();
        ser.execute(t);

        while (true){
            int val = t.getValue();
            if(val%2 != 0){
                System.out.print("error int");
                System.exit(0);
            }
        }
    }
}

class ThreadUseAtomic implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public void run() {
        while(true)
            i.getAndAdd(2);
    }

    public int getValue() {
        return i.get();
    }
}
