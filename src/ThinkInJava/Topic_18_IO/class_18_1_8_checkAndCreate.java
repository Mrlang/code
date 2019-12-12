package ThinkInJava.Topic_18_IO;

import org.junit.Test;

import javax.print.attribute.standard.PrinterStateReason;
import java.io.*;
import java.nio.file.DirectoryStream;

/**
 * Created by Mr_liang on 2017/2/24 using IDEA.
 */
public class class_18_1_8_checkAndCreate {
    public static void main(String args[]) throws Exception{
        File f = new File("/Users/Mr_liang/Sites/121.php");
        System.out.println(f.isDirectory() + ","+ f.canRead()+","+f.length()+","+f.getName()+","+f.getPath()+","+f.getAbsolutePath()+","+f.lastModified());
        boolean b = f.renameTo(new File("/var/121.php"));
        System.out.println(b);
        File f1  = new File("/222");
        boolean a = f1.mkdirs();
        System.out.println(a);
        new FilterOutputStream(new ByteArrayOutputStream());
        FileReader fReader = new FileReader("/");
//        BufferedReader bReader = new BufferedReader();
//        new FilterReader();
//        new StringReader();
//        new PipedReader();
//        new CharArrayReader();
    }


    @Test
    public void test(){
        byte[] b = "王".getBytes();
        System.out.println("王".length());
    }
    
    @Test
    public void test2(){
        
    }
}
