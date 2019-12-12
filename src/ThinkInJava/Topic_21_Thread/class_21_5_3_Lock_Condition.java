package ThinkInJava.Topic_21_Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_21_5_3_Lock_Condition {
    public static void main(String args[]) throws Exception{
        Cari c = new Cari();
        ThreadPoolExecutor exc = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        exc.execute(new WaxOnThreadi(c));
        exc.execute(new WaxOffThreadi(c));
        TimeUnit.SECONDS.sleep(3);
        exc.shutdownNow();
    }
}


class Cari{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    private boolean waxOn = false;
    public void waxOn() {
        lock.lock();
        try{
            waxOn = true;
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public void waxOff(){
        lock.lock();
        try{
            waxOn = false;
            condition.signalAll();
        }finally{
            lock.unlock();
        }
            
    }

    public void waitingWaxOn() throws InterruptedException{
        lock.lock();
        try{
            while(waxOn == false) {
                condition.await();
            }
        }finally{
            lock.unlock();
        }
            
    }

    public void waitingWaxOff() throws InterruptedException{
        lock.lock();
        try{
            while(waxOn == true){
                condition.await();
            }
        }finally{
            lock.unlock();
        }
            
    }
}

class WaxOnThreadi implements Runnable{
    private Cari car;
    public WaxOnThreadi(Cari c){
        this.car = c;
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()) {
                System.out.println("WaxOnThreadi:begin waxOn");
                Thread.sleep(200);
                car.waxOn();
                System.out.println("WaxOnThreadi:finish waxOn");
                System.out.println("WaxOffThreadi: waiting waxOff");
                car.waitingWaxOff();
            }
        }catch(InterruptedException e) {
            System.out.println("WaxOnThreadi:cat exception");
        }
        System.out.println("exit from WaxOnThreadi");
    }
}

class WaxOffThreadi extends Thread{
    private Cari car;
    public WaxOffThreadi(Cari c){
        car = c;
    }

    @Override
    public void run() {
        try{
            while(!interrupted()) {
                System.out.println("WaxOffThreadi: waiting waxOn");
                car.waitingWaxOn();
                System.out.println("WaxOffThreadi: begin waxOff");
                sleep(500);
                car.waxOff();
                System.out.println("WaxOffThreadi: finish waxOff");
            }
        }catch(InterruptedException e) {
            System.out.println("WaxOffThreadi: cat exception");
        }
        System.out.println("exit from WaxOffThreadi");

    }
}