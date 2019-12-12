package ThinkInJava.Topic_14_Reflect;

import org.junit.Test;

import java.util.*;

/**
 * Created by Mr_liang on 2016/11/28.
 */
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = class_14_2_1.rand.nextInt(1000);
    static{
        System.out.println("Initialzing Initable");
    }
}

class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initialzing Initable2");
    }
}

class Initable3{
    static int staticNonFinal = 74;
    static {
        System.out.println("Initialzing Initable3");
    }
}

public class class_14_2_1 {
    public static Random rand = new Random(47);
//    public static void Main(String args[]) throws Exception{
    @Test
    public void test() throws Exception{
        Class initable = Initable.class;
        System.out.println("after creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);

        System.out.println(Initable2.staticNonFinal);

//        Class initable3 = Class.forName("Initable1");
        Class s3 = Initable3.class;
        System.out.println("after creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        //虽然Integet是Number的子类,但Class类并不是Class类的子类,现在需要的是Number-Class类,required Class<jva.lang.Number> but found Class<java.lang.Integer>
//        Class<Number> numberClass = int.class;

        Class<?> generalClass = int.class;
        generalClass = double.class;

        Class<? extends Number> allNumberClass = int.class;
        allNumberClass = double.class;
        allNumberClass = Number.class;
    }
}


