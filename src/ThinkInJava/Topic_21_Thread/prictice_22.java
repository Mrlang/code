package ThinkInJava.Topic_21_Thread;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.*;

/**
 * @author wangliang01 on 2019/3/7 using IDEA.
 */
public class prictice_22 {
    public static void main(String args[]) throws InterruptedException {
        Boolean obj = false;
        Runnable run1 = new R1(obj);
        Runnable run2 = new R2(obj);
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 5L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory());

        executorService.execute(run1);
        executorService.execute(run2);
    }

}
class R1 implements Runnable{

    private Boolean aBoolean;

    public R1(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aBoolean = true;
    }
}

class R2 implements Runnable{
    private Boolean obj;

    public R2(Boolean obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
      while(true) {
          if(obj == true){
              System.out.println("变为true了");
              obj = false;
          }
      }
    }
}
