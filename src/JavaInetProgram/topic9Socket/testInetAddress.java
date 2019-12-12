package JavaInetProgram.topic9Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Created by Mr_liang on 2017/3/1 using IDEA.
 */
public class testInetAddress {
    public static void main(String args[]) throws UnknownHostException {
        InetAddress add = InetAddress.getByName("www.163.com");
        System.out.println("add is "+add);
        InetAddress add3 = InetAddress.getByName("123.138.60.192");
        System.out.println("add3 is " + add3);
//        InetAddress add1 = InetAddress.getByAddress("202202043125".getBytes());
//        System.out.println("add1 is "+ add1);
        InetAddress add2 = InetAddress.getLocalHost();
        System.out.println("add2 is "+add2);
        String hostName = add3.getHostName();
        System.out.println("add3 hsotname is "+hostName);
        String ip = add.getHostAddress();
        System.out.print("add ip is "+ip);

    }
}
