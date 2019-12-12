package ThinkInJava.Topic_21_Thread;

/**
 * Created by Mr_liang on 2017/8/23 using IDEA.
 */
public class waitNotify {

    public static void main(String args[]){
        MyThread thread = new MyThread();
        synchronized (thread){
            System.out.println("start thread");
            thread.start();
            System.out.println("wait");
            try {
                thread.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait end");
        }
    }

    static class MyThread extends Thread{
        @Override
        public synchronized void run() {
            while (true){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notify();

            }
        }
    }
}


