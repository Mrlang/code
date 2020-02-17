package concurrent.crossPrintNumber;

/**
 * Created by wangliang01 on 2020/2/17 using IDEA.
 */
public class Demo2_waitNotify {
    public static int i = 0;

    public static void main(String args[]){
        Object obj = new Object();
        new Thread(() ->{
            synchronized (obj) {
                while(i<30) {
                    if(i % 3 == 0){
                        System.out.println("t1:" + (++i));
                    }
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notifyAll();
            }
        }).start();


        new Thread(() -> {
            synchronized (obj) {
                while(i<30) {
                    if(i % 3 == 1){
                        System.out.println("t2:" + (++i));
                    }
                    obj.notifyAll();
                    try{
                        obj.wait();
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                obj.notifyAll();
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                while(i<30) {
                    if(i % 3 == 2){
                        System.out.println("t3:" + (++i));
                    }
                    obj.notifyAll();
                    try{
                        obj.wait();
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                obj.notifyAll();
            }
        }).start();
    }
}
