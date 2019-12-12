package ThinkInJava.Topic_21_Thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mr_liang on 2017/2/20 using IDEA.
 */
public class class_21_3_7_ThreadLocal {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {private Random rand = new Random(47);@Override protected synchronized Integer initialValue() {return rand.nextInt(10000);}};

    public static void main(String args[]) throws Exception{
        method_1();   //说那个76-78行
//        method_2();//使用80-82行 ,效果是一样。就是所有线程必须使用同一个ThreadLocal对象
        TimeUnit.MILLISECONDS.sleep(5);
        System.exit(0);
    }

    @Test
    public void test(){
        System.out.println(new Random(47).nextInt(10000));
        System.out.println(new Random(47).nextInt(10000));
        System.out.println(new Random(47).nextInt(10000));
        Random rand = new Random(55);
        System.out.println(rand.nextInt(500));
        System.out.println(rand.nextInt(500));
        System.out.println(rand.nextInt(500));
    }

    public static void increment(){
        value.set(value.get()+1);
    }

    public static int get(){
        return value.get();
    }

    public static void method_1(){
        ThreadLocalImp local = new ThreadLocalImp();
        ThreadPoolExecutor ser = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for(int i=0; i< 5; i++) {
            ser.execute(new testthread(i, local));
        }
        ser.shutdown();
    }

    public static void method_2() {
        ExecutorService ser = Executors.newCachedThreadPool();
        for(int i=0; i< 5; i++) {
            ser.execute(new testthread(i));
        }
    }
}

class testthread implements Runnable{
    private final int t_id;
    private ThreadLocal<Integer> local;
    public testthread(int t_id, ThreadLocal<Integer> local) {
        this.t_id = t_id;
        this.local = local;
    }
    public testthread(int t_id){
        this.t_id = t_id;
    }

    @Override
    public void run() {
        while(true) {

            local.set(local.get()+1);
            System.out.println("this is testThread_"+t_id+": value is "+local.get());
            Thread.yield();


//            class_21_3_7_ThreadLocal.increment();
//            System.out.println(this);
//            Thread.yield();
        }

    }

    public String toString(){
        return "#"+t_id+": "+class_21_3_7_ThreadLocal.get();
    }
}

class ThreadLocalImp extends ThreadLocal<Integer>{
    private Random rand = new Random(47);
    @Override
    protected synchronized Integer initialValue() {
        return rand.nextInt(10000);
    }
}


