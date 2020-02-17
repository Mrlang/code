package concurrent.crossPrintNumber;

/**
 * Created by wangliang01 on 2020/2/17 using IDEA.
 */
public class Demo1_waitNotify {
    public static int i = 0;

    public static void main(String args[]){
        Object obj = new Object();
        new Thread(() ->{
            synchronized (obj) {
                while(i<10) {
                    System.out.println("t1:" + (++i));
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }).start();


        new Thread(() -> {
            synchronized (obj) {
                while(i<10) {
                    System.out.println("t2:" + (++i));
                    obj.notify();
                    try{
                        obj.wait();
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }).start();
    }
}
