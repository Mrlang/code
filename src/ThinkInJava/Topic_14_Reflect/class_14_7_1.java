package ThinkInJava.Topic_14_Reflect;

import java.util.ArrayList;

/**
 * Created by Mr_liang on 2016/12/14.
 */
public class class_14_7_1 {
    public static void main(String args[]){
        test(new realObj());
        test(new proxyObj(new realObj()));
    }

    public static void test(Inter a){
        a.doFirst();
        a.doSecond("22");
    }

}

interface Inter{
    public void doFirst();
    public void doSecond(String arg);
}

class realObj implements Inter{
    @Override
    public void doFirst() {
        System.out.println("readObj do First Method");
    }

    @Override
    public void doSecond(String arg) {
        System.out.println("realObj do Second Method,param is"+ arg);
    }
}

class proxyObj implements Inter{
    private Inter realObj;

    public proxyObj(Inter realObj) {
        this.realObj = realObj;
    }

    @Override
    public void doFirst() {
        System.out.print("proxyObj do First Method:");
        realObj.doFirst();
    }

    @Override
    public void doSecond(String arg) {
        System.out.print("proxyObj do Second Method:");
        realObj.doSecond(arg);
    }
}