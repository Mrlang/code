package ThinkInJava.Topic_21_Thread;

import javax.swing.text.html.HTML;

/**
 * Created by Mr_liang on 2017/2/19.
 */
public class class_21_2_10 {
    static before b1 = new before("before1");
    static after a1 = new after("after1", b1);
    static before b2 = new before("before2");
    static after a2 = new after("after2", b2);

    public static void main(String args[]) {
        test2();
    }

    public static void test1() {
        a1.start();
        System.out.println("thread Main:b1 start");
        b1.start();
    }

    public static void test2() {
        b2.start();
        a2.start();
        b2.interrupt();
    }
}

class before extends Thread {
    before(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("threadBefore:this is threadBefore, i am going sleeping, other thread can run");
        try{
            sleep(5000);
            System.out.println("threadBefore : sleep end");
        }catch(InterruptedException e) {
            System.out.println("threadBefore: be interrupted, this.isInterrupted() = "+this.isInterrupted());
//            return;
        }

    }
}

class after extends Thread {
    before b;
    after(String name, before b){
        super(name);
        this.b = b;
    }
    @Override
    public void run() {
        System.out.println("threadAfter : begin join anther thread");
        try{
            b.join();
        }catch(InterruptedException e) {
            System.out.println("error : join interrupted");
        }
        System.out.println("threadAfter : join end");
    }
}