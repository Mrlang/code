package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_liang on 2017/2/18.
 */
public class class_21_2_5 {
    public static void main(String args[]){
        ExecutorService ser = Executors.newCachedThreadPool();
        for(int i=0; i< 5; i++) {
            ser.execute(new sleepTimer());
        }
        ser.shutdown();
    }


}

class sleepTimer extends timer {
    public void run() {
        while(times-- > 0) {
            System.out.println("Time_Thrad_"+threadId+": time is "+times);
            try{
                TimeUnit.MILLISECONDS.sleep(2000);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
