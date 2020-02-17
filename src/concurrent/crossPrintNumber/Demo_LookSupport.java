package concurrent.crossPrintNumber;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wangliang01 on 2020/2/17 using IDEA.
 */
public class Demo_LookSupport {
    static int i = 0;
    static Thread t1,t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            while (i<10) {
                System.out.println("t1:" + (++i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<10) {
                    LockSupport.park();
                    System.out.println("t2:" + (++i));
                    LockSupport.unpark(t1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
