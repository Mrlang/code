package ThinkInJava.Topic_18_IO.NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by Mr_liang on 2017/5/1 using IDEA.
 */
public class SocketChannelTest {
    public static void main(String args[]) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));
        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
            System.out.println("not connect");
        }
    }

}
