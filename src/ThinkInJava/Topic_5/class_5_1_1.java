package ThinkInJava.Topic_5;

import org.junit.Test;

/**
 * Created by Mr_liang on 2016/12/6.
 */
public class class_5_1_1 {
    //当调用到构造器的时候，如果一个类没有默认构造器(即没有参数，方法体为空的构造器)，那就不能调用无参的默认构造器，必须按照显式构造器的需要进行传参。
//    @Test
//    public void Topic3_2_StaticTest(){
//        parent p_1 = new parent();
//        parent p_2 = new parent(12);
//        parent_1 p_3 = new parent_1();
//        parent_1 p_4 = new parent_1(12);
//    }
}

class parent{
    int age;
    parent(){

    }

    parent(int age){
        this.age = age;
    }
}
class child extends parent{
    child(){
        super();
    }

    child(int age){
        super(age);
    }
}

class parent_1{
    int age;
    parent_1(int age){

    }
}

class child_1 extends parent_1{
    /*
    child_1(){
        super();
    }
    */

    child_1(int age){
        super(age);
    }
}
