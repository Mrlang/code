package ThinkInJava.Topic_18_IO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mr_liang on 2017/3/11 using IDEA.
 */
public class practice {
    public static void main(String args[]) throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream("wangliang".getBytes()));
        while(in.available() != 0) {
            System.out.println((char)in.readByte());
        }
    }
}
