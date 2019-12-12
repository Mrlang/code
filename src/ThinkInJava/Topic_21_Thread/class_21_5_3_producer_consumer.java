package ThinkInJava.Topic_21_Thread;

import com.sun.deploy.util.Waiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_21_5_3_producer_consumer {
    public static void main(String args[]) {
        new Restaurant();
    }
}

class Meal {
    final int mealId;
    public Meal(int a) {
        mealId = a;
    }
}

class Restaurant{
    Meal meal;
    ThreadPoolExecutor ser = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    Waite w = new Waite(this);
    Chef c = new Chef(this);
    public Restaurant(){
        ser.execute(c);
        ser.execute(w);
    }
}

class Waite extends Thread{
    private Restaurant res;
    public Waite(Restaurant r){
        this.res = r;
    }

    @Override
    public void run() {
        try{
            while(!interrupted()) {
                synchronized (this) {
                    while (res.meal == null) {
                        System.out.println("wait for a meal");
                        wait();
                    }


                    synchronized (res.c) {
                        System.out.println(" end a meal:" + res.meal.mealId);
                        res.meal = null;
                        sleep(200);
                        res.c.notifyAll();
                    }
                }
            }
        }catch(InterruptedException e) {
            System.out.println("waiter exception");
        }

    }
}

class Chef extends Thread{
    private int count=0;
    private Restaurant res;
    public Chef(Restaurant r) {
        res = r;
    }

    @Override
    public void run() {
        try{
            while(!interrupted()) {
                synchronized (this){
                    while(res.meal != null) {
                        System.out.println("chef wait meal null");
                        wait();
                    }
                }
                if(++count > 10){
                    System.out.println("finish 10 meals");
                    res.ser.shutdownNow();
                }
                synchronized (res.w){
                    res.meal = new Meal(count);
                    System.out.println("chef give a meal"+count);
                    TimeUnit.MILLISECONDS.sleep(200);
                    res.w.notifyAll();
                }

            }
        }catch(InterruptedException e) {
            System.out.println("chef exception");

        }

    }
}

/*
chef give a meal1
chef wait meal null
 end a meal:1
wait for a meal
chef give a meal2
chef wait meal null
 end a meal:2
wait for a meal
chef give a meal3
chef wait meal null
 end a meal:3
wait for a meal
chef give a meal4
chef wait meal null
 end a meal:4
wait for a meal
chef give a meal5
 end a meal:5
wait for a meal
chef give a meal6
chef wait meal null
 end a meal:6
wait for a meal
chef give a meal7
chef wait meal null
 end a meal:7
wait for a meal
chef give a meal8
chef wait meal null
 end a meal:8
wait for a meal
chef give a meal9
chef wait meal null
 end a meal:9
wait for a meal
chef give a meal10
chef wait meal null
 end a meal:10
wait for a meal
finish 10 meals
chef give a meal11
waiter exception
chef exception

Process finished with exit code 0
*/