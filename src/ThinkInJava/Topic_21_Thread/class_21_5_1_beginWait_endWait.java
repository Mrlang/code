package ThinkInJava.Topic_21_Thread;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_5_1_beginWait_endWait {
    public static void main(String args[]) throws Exception{
        Object o = new Object();
        new waitThread(o).start();
        System.out.println("Main sleep 3s");
        Thread.sleep(3000);
        System.out.println("notifyAll");
        synchronized (o){
            o.notifyAll();
        }
        synchronized (o){
            System.out.println("get Obj Lock,sleep 3");
            Thread.sleep(3000);
            System.out.println("end sleep");
        }
    }
}

class waitThread extends Thread{
    private Object obj;
    public waitThread(Object o){
        obj = o;
    }
    @Override
    public void run() {
        try{
            synchronized (obj){
                obj.wait();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("was notify");
    }
}
