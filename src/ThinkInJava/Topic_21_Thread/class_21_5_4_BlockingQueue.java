package ThinkInJava.Topic_21_Thread;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_21_5_4_BlockingQueue {
    public static void main(String args[]) {
        LiftOffRunner runner = new LiftOffRunner(new LinkedBlockingDeque<LiftOff>());
        runner.start();
        for(int i=0; i< 5; i++) {
            runner.add(new LiftOff(5));
        }
        runner.interrupt();
    }
}

class LiftOff extends Thread{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int i){countDown = i;}

    public String status(){
        return "#"+id+"("+(countDown>0 ? countDown : "LiftOff!") + ").";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(Thread.currentThread()+" ; "+status());
            Thread.yield();
        }
    }
}

class LiftOffRunner extends Thread{
    private BlockingQueue<LiftOff> que;
    public LiftOffRunner(BlockingQueue<LiftOff> q){
        que = q;
    }
    public void add(LiftOff l){
        try{
            que.put(l);
        }catch(Exception e) {
            System.out.println("add inter exception");
        }
    }

    @Override
    public void run() {
        try{
            while (!interrupted()){
                LiftOff l = que.take();
                l.run();
            }
        }catch(InterruptedException e) {
            System.out.println("runner intered");
        }finally{

        }
    }
}


