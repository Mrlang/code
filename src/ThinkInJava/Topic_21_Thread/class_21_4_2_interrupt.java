package ThinkInJava.Topic_21_Thread;

import org.junit.Test;

/**
 * Created by Mr_liang on 2017/2/21 using IDEA.
 */
public class class_21_4_2_interrupt {
    public static void main(String args[]) {
        new Thread(){public void run(){new test().f1(10);}}.start();
    }

    @Test
    public void test(){
        int a=1;
        if(a-- >0)
            System.out.println("asdfas");
        System.out.println(a);
    }
}

class test {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1() calling f2() with count :" + count);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2() calling fi() with count :" + count);
            f1(count);
        }

    }
}
