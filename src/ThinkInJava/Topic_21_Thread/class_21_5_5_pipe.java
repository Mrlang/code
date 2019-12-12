package ThinkInJava.Topic_21_Thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_21_5_5_pipe {
    public static void main(String args[]) throws Exception{
        sender s = new sender();
        receiver r = new receiver(s);
        ExecutorService ser = Executors.newCachedThreadPool();
        ser.execute(s);
        ser.execute(r);
        Thread.sleep(5000);
        ser.shutdownNow();
    }
}

class sender extends Thread{
    private PipedWriter out = new PipedWriter();
    public PipedWriter getOut(){
        return out;
    }

    @Override
    public void run() {
        try{
            while (true){
                for(int i=0; i< 10; i++) {
                    out.write("aA"+i);
                }
                System.out.println("sleep 5000");
                sleep(5000);
                break;
            }
            System.out.println("out while");
        }catch(IOException e) {
            System.out.println("IP exception");
        }catch(InterruptedException e){
            System.out.println("inter exception");
        }

    }
}

class receiver extends Thread{
    private PipedReader in;
    public receiver(sender sender) throws Exception{
        in = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        try{
            while(true) {
                System.out.println("Read:" + in.read());
            }
        }catch(Exception e) {
            System.out.println("rece exception");
        }

    }
}
