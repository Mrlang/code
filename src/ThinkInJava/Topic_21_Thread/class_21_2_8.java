package ThinkInJava.Topic_21_Thread;

/**
 * Created by Mr_liang on 2017/2/18.
 */
public class class_21_2_8 {
    public static void main(String args[]){
        testFinal2();
    }

    public static void testFinal() {
        Thread t = new Thread(new Adeamon());
        t.setDaemon(true);
        t.start();
        try{
            Thread.sleep(10000);
            System.out.println("thread Main:3~10 seconds");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFinal2() {
        Thread t = new Thread(new Adeamon());
//        t.setDaemon(true);
        t.start();
        try{
            Thread.sleep(1000);
            System.out.println("thread Main:1 seconds");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Adeamon implements Runnable {
    @Override
    public void run(){
        //Thread.currentThread().setDaemon(true);   //Exception in thread "Thread-0" java.lang.IllegalThreadStateException
        System.out.println("this is Adeamon");
        try{
            Thread.sleep(3000);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("thread deamon :3 second ,this is final");
        }
    }
}

class a extends Thread{
    @Override
    public void run() {
        setDaemon(true);
        setPriority(MIN_PRIORITY);
    }
}
