package ThinkInJava.Topic_18_IO;

import java.io.*;

/**
 * Created by Mr_liang on 2017/2/26 using IDEA.
 */
public class File_In_Out_putStream_Test {
    public static void main(String args[]) throws IOException {
        testFile();
    }
    public static void testFile() throws IOException {
        File f = new File("out.txt");
        System.out.println(f.getAbsolutePath());
        FileOutputStream outputStream = new FileOutputStream(f, false);
        FileDescriptor fd = outputStream.getFD();
        FileOutputStream outputStream1 = new FileOutputStream(f, false);
        outputStream.write("a".getBytes());
        outputStream1.write("b".getBytes());
        outputStream.close();
        outputStream1.close();
        String.valueOf(0x61);
        Integer.valueOf(3);
    }
}