package ThinkInJava.Topic_5;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Mr_liang on 2016/12/14.
 */
public class class_5_3_1 {
    public static void main(String args[]){
        new thisTest().m2();
    }
}

class thisTest{
    public void m1(){
        System.out.println("no this function m1");
    }

    public void m2(){
        this.m1();
        this.m1();
    }
}
