package ThinkInJava.Topic_18_IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Mr_liang on 2017/2/24 using IDEA.
 */


public class BufferedInputFile {
    public static void main(String args[]) throws Exception {
//        System.out.println(read("/s/121.php"));
        new FileReader("/s/121.php");
        char a = 'a';
        String b = "燕";
        byte[] bs = b.getBytes();
        for (byte str : bs) {
            System.out.println(str);
        }
        String s = new String(new char[]{a});
        System.out.println(s.getBytes().length);
        System.out.println((int) a);
        System.out.println((char) (byte) a);
        List<String> l = new LinkedList<String>();
        l.add("ccc");
        l.add("bac");
        l.add("cab");
        System.out.printf("list is %s\nok\n", l);
        System.out.println("first is "+l.get(0));
        HashMap<List, String> m = new HashMap<>();
        m.put(l,"1");
        m.put(l,"2");
        System.out.println("map.l is "+m.get(l));
        long lon = System.currentTimeMillis();
        System.out.println("long lon is "+lon+", int lon is "+(int)(lon%100));
        double d = Math.random();
        System.out.println("d is "+d +", int d is "+(int)(d*100));
        Random ran1 = new Random(100);
        System.out.println("ran1 is "+ran1.nextInt());
        System.out.println("ran2 is "+new Random(100).nextInt());
        System.out.println(new Random(47).nextInt());
        System.out.println(new Random(47).nextInt());
    }

    public static String read(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            sb.append(s+"\n");
        }
        br.close();
        return sb.toString();
    }
}
