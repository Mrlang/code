package ThinkInJava.Topic_21_Thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Mr_liang on 2017/2/18.
 */

public class class_21_2_3 {
    public static void main(String args[]){
        newSingleThreadExecutor();
    }

    @Test
    public void test(){
        for(int i=0; i< 5; i++) {
            new Thread(new timer()).start();
        }
//        new Thread(new timer()).start();
        System.out.println("test exit");
    }

    public static void newCachedThreadPool(){
        /**
         * Creates a thread pool that creates new threads as needed, but
         * will reuse previously constructed threads when they are
         * available.
         */
         ExecutorService executorService = Executors.newCachedThreadPool();
         System.out.println("thread Main:add tasks to executorService begin");
         for(int i=0; i< 5; i++) {
         executorService.execute(new timer());   //  就相当于new Thread(new timer()).start();创建一个线程之后,这个新线程立马就可以和主线程交替使用CPU执行任务。
         System.out.println("thread Main:timer "+i + " create success");
         }
         System.out.println("thred Main:add tasks executorService end");
         executorService.shutdown();
    }

    public static void newFixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i< 5; i++) {
            executorService.execute(new timer());
        }
        executorService.shutdown();
    }

    public static void newSingleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("thread Main: add all begin");
        for(int i=0; i< 5; i++) {
            executorService.execute(new timer());
            System.out.println("thread Main: create timer_"+i +"success");
        }
        executorService.execute(new timer());   //一边执行队列头的任务,一边等待队列尾部加入新任务。
        System.out.println("add new timer");
        try{
            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.execute(new timer());
        executorService.shutdown();
        System.out.println("thread Main: add all end");
    }

}
