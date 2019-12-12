package ThinkInJava.Topic_21_Thread;

/**
 * Created by Mr_liang on 2017/2/18.
 */
public class class_21_2_2 {
    public static void main(String args[]){
        for(int i=0; i< 5; i++) {
            new Thread(new timer()).start();
        }
        System.out.println("Main end----");
    }
}

class timer implements Runnable{
    protected int times = 10;
    private static int taskCount = 0;
    protected final int threadId = taskCount++;

    @Override
    public void run() {
        while(times-- > 0) {
            System.out.println("Time_Thrad_"+threadId+": time is "+times + "; is daemon : "+ Thread.currentThread().isDaemon());
            Thread.yield();
        }
    }
} 