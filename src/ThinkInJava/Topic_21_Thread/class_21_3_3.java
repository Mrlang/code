package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_liang on 2017/2/19 using IDEA.
 */
public class class_21_3_3 {
    public static void main(String args[])  throws Exception{
        serialIntGenerator gen = new serialIntGenerator();
        CircleIntset set = new CircleIntset(2);
        ExecutorService ser = Executors.newCachedThreadPool();
        for(int i=0; i< 10; i++) {
//            ser.execute(new getIntThread(new serialIntGenerator(), new CircleIntset(2)));
            ser.execute(new getIntThread(gen, set));
        }
        ser.shutdown();
        System.out.println("Main sleep 10 seconds");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("no the same number");
        System.exit(0);//程序退出,中断所有线程。
    }
}

class CircleIntset{
    volatile int[] array;
    int length;
    private volatile  int index = 0;

    CircleIntset(int length){
        array = new int[length];
        this.length = length;
        for(int i=0; i< length; i++) {
            array[i] = 0;
        }
    }
    public synchronized  void add(int value){
        array[index] = value;
        index = ++index % length;
    }
    public synchronized boolean contains(int value){
        for(int i=0; i< length; i++) {
//            System.out.println(array[i]);
            if(array[i] == value)
                return true;
        }
        return false;
    }

    public synchronized int getValue(){
        return array[index];
    }

}

class serialIntGenerator extends AbstractIntGenerator{
    private volatile int serialInt = 0;
    @Override
    public  int next() {
//        int temp = serialInt + 1;
//        try{
//            Thread.sleep(100);
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        Thread.yield();
//        serialInt = temp;
        return ++serialInt;
    }
}

class getIntThread extends Thread{
    private serialIntGenerator gen;
    private CircleIntset set;
    private boolean flag = true;
    public getIntThread(serialIntGenerator gen, CircleIntset set){
        this.gen = gen;
        this.set = set;
    }

    @Override
    public void run() {
        while(true) {
            int value = gen.next();
            if(set.contains(value)){
                System.out.println("set contains value:"+value+",exit");
                System.exit(0);
            }
            set.add(value);
            System.out.println("add:value is "+set.getValue());
        }

    }
}