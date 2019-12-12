package ThinkInJava.Topic_21_Thread;

import java.io.InputStream;
import java.net.ServerSocket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_4_3_interrupt_2 {
    public static void main(String args[]) throws Exception{
        ThreadPoolExecutor exc = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ServerSocket serve = new ServerSocket(8080);
//        InputStream socketInput = new ServerSocket("localhost",8080).getInputStream();
//        exc.execute(new IOBloacked(socketInput));
        exc.execute(new IOBlockedThread(System.in));
        TimeUnit.SECONDS.sleep(2);
        System.out.println("begin shutdownnow()");
        exc.shutdownNow();
        TimeUnit.SECONDS.sleep(2);
//        System.out.println("closing socketInput");
//        socketInput.close();
        System.out.println("begin closing system.in");
        System.in.close();
    }
}
