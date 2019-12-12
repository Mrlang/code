package Interview;

import org.junit.Test;

/**
 * Created by Mr_liang on 2016/11/30.
 */
public class Topic1_2 {
    @Test
    public void test1(){
        Child c = new Child();
    }
}

class Parent{
    public Parent(){
        System.out.println("this is parent constructor");
    }

    public int Parent(){
        return 1;
    }
}

class Child extends Parent{
    public Child(){
        System.out.println("this is child constructor");
    }

    public int Child(){
        return 2;
    }
}
