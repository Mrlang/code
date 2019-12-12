package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.*;

/**
 * @author wangliang01 on 2019/3/7 using IDEA.
 */
public class prictice_21 {
    public static void main(String args[]) throws InterruptedException {
        Object obj = new Object();
        Runnable run1 = new Run1(obj);
        Runnable run2 = new Run2(obj);
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 5L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory());
        executorService.execute(run1);
        executorService.execute(run2);
        System.out.println("yield");
        Thread.yield();

        executorService.shutdown();
        System.out.println("shuwdown");

    }
}

class Run1 implements Runnable{

    private Object obj;

    public Run1(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("run1 begin run");
        synchronized (obj) {
            try{
                obj.wait();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("okokok");
    }
}

class Run2 implements Runnable{
    private Object obj;

    public Run2(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("run2 begin run");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
