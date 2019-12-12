package Interview;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Mr_liang on 2016/12/4.
 */

/*
    public的static的方法：没有任何权限问题，getMethod()就可以满足，根本不用getDeclaredMethod出马，更不用setAccessiable(true)
    public的非静态的方法：没有任何权限问题，getMethod()就可以满足，根本不用getDeclaredMethod出马，更不用setAccessiable(true)，
    但是，在invoke时，第一个参数必须是具体的某一个对象，static的可要可不要
    protected的非静态方法：必须使用getDeclaredMethod，不能使用getMethod，不用设置setAccessiable(true)
    friendly的非静态方法：必须使用getDeclaredMethod，不能使用getMethod，不用设置setAccessiable(true)
    private的非静态方法：必须使用getDeclaredMethod，不能使用getMethod，必须设置setAccessiable(true)
*/
public class Topic9_1_reflect {
    @Test
    public void test(){
        MethodTest methodTest = new MethodTest();
        testMethod(methodTest);

        FieldTest fieldTest = new FieldTest();
        testField(fieldTest);

    }

    public void testField(FieldTest fieldTest){
        try {
            Field f = FieldTest.class.getDeclaredField("age");
            int a = (Integer) f.get(fieldTest);
            System.out.println("age is "+a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testMethod(MethodTest methodTest){
        try{
            Class<MethodTest> c = MethodTest.class;
            Method m = c.getDeclaredMethod("m2",String.class);
            MethodTest obj = c.newInstance();
            m.invoke(obj,"我知道了,要传参数啊,玛德");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class MethodTest{
    public void m1(String arg){
        System.out.println("this is method 1, param is " + arg);
    }

    public void m2(String arg){
        System.out.println("this is method 2, param is "+arg);
    }
}

class FieldTest{
    public String name;
    public int age;
}
