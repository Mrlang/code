package ThinkInJava.Topic_21_Thread;

import java.beans.IntrospectionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_5_1_wait_notify {
    public static void main(String args[]) throws Exception{
        Car c = new Car();
        ThreadPoolExecutor exc = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        exc.execute(new WaxOnThread(c));
        exc.execute(new WaxOffThread(c));
        TimeUnit.SECONDS.sleep(3);
        exc.shutdownNow();
    }
}

class Car{
    protected boolean waxOn = false;
    public synchronized void waxOn() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void waxOff(){
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitingWaxOn() throws InterruptedException{
        while(waxOn == false) {
            wait();
        }
    }

    public synchronized void waitingWaxOff() throws InterruptedException{
        while(waxOn == true){
            wait();
        }
    }
}

class WaxOnThread implements Runnable{
    protected Car car;
    public WaxOnThread(Car c){
        this.car = c;
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()) {
                System.out.println("WaxOnThread:begin waxOn");
                Thread.sleep(200);
                car.waxOn();
                System.out.println("WaxOnThread:finish waxOn");
                System.out.println("WaxOffThread: waiting waxOff");
                car.waitingWaxOff();
            }
        }catch(InterruptedException e) {
            System.out.println("WaxOnThread:cat exception");
        }
        System.out.println("exit from WaxOnThread");
    }
}

class WaxOffThread extends Thread{
    protected Car car;
    public WaxOffThread(Car c){
        car = c;
    }

    @Override
    public void run() {
        try{
            while(!interrupted()) {
                System.out.println("WaxOffThread: waiting waxOn");
                car.waitingWaxOn();
                System.out.println("WaxOffThread: begin waxOff");
                sleep(500);
                car.waxOff();
                System.out.println("WaxOffThread: finish waxOff");
            }
        }catch(InterruptedException e) {
            System.out.println("WaxOffThread: cat exception");
        }
        System.out.println("exit from WaxOffThread");

    }
}