package Interview;

import org.junit.Test;
/**
 * Created by Mr_liang on 2016/12/6.
 */

//java内部类  P67
public class Topic3_2_InnerClass {
    public static int a = 10;
    public String s = "outer_str";
    //静态内部类
    static class Inner{
        public void prin(){
            System.out.println("s is "+a);//类是静态的,只能访问外部类的静态成员
        }
    }

    //成员内部类
    class Inner_1{
        public void print(){
            System.out.println("a is "+a+ ",s is "+s+",outer class is " + Topic3_2_InnerClass.this);
        }
    }

    //理论上,如果想从
    public  void creatInner(){
        Inner i0 = new Inner();
        Inner i = new Topic3_2_InnerClass.Inner();

        Inner_1 inner_1 = new Inner_1();
        Inner_1 i_1 = new  Topic3_2_InnerClass.Inner_1();
    }

    public static void main(String a[]){
        Inner i = new Inner();  //静态内部类对于外部类来说(除了访问外部类的静态成员)几乎是独立的,可直接实例化
        i.prin();

        Inner_1 i1 = new Topic3_2_InnerClass().new Inner_1();
        i1.print();

    }

    @Test
    public void test(){
        creatInner();
    }

    @Test
    //测试外面的类的内部类
    public void test2(){
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.printInt();

        //Outer.NoStaticInner noStaticInner = new Outer.NoStaticInner();//error:需要包含Outer.NoStaticInner的封闭实例
        Outer outer = new Outer();
        Outer.NoStaticInner noStaticInner = outer.new NoStaticInner();
        noStaticInner.printInt();

        outer.createrInner();
    }
}




class Outer{
    public static int staticInt = 10;
    public  int NoStaticInt = 1;
    public String outString  = "OuterClassString";
    static class StaticInner{
        public void printInt(){
            System.out.println("staticInt is " + staticInt);
        }
    }

    class NoStaticInner{
        public void printInt(){
            System.out.println("staticInt is "+staticInt+", NoStaticInt is "+NoStaticInt);
        }
    }

    public void createrInner(){
        StaticInner staticInner = new StaticInner();
        NoStaticInner noStaticInt = new NoStaticInner();
    }

    public static void creInnrt(){
        StaticInner staticInner = new StaticInner();
//        NoStaticInner noStaticInt = new NoStaticInner();
    }
}