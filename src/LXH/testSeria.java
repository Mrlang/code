package LXH; /**
 * Created by Mr_liang on 16/8/17.
 */

import org.junit.Test;

import java.io.*;
import java.util.HashMap;

class Serialize implements Serializable{

    private static final long serialVersionUID = -5211389707739541364L;
    public int num = 1390;
    public String s;
    public void setString(String s){
        this.s = s;
    }
    public void checkIsSame()
    {
        String s = new String("string");
        Serialize serialize1 = new Serialize();
        serialize1.setString(s);
        try
        {
            FileOutputStream fos = new FileOutputStream("serialize.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serialize1);
            oos.flush();
            oos.close();//只是为了方便简洁的做个例子，真实编程要放到finally下，懂的人你懂的。
            fos.close();
            System.out.println("序列化结束");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Serialize serialize2 = null;
        try
        {
            FileInputStream fis = new FileInputStream("serialize.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);

            serialize2 = (Serialize) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("反序列化结束");
        }
        catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("序列化和反序列化的对象相同否？"+(serialize1==serialize2));
        System.out.println("序列化和反序列化的对象里的属性相同否？"+(serialize1.s.equals( serialize2.s)));
    }

    public static  char p;
    public static void main(String[] args)
    {
        new cup();
        System.out.println(cup.b);
//        LXH.Serialize serialize = new LXH.Serialize();
//        serialize.checkIsSame();
        String str = "string";
        byte b[] = new byte[]{'b','c','d'};
        String c  = new String(b);
        byte d[] = c.getBytes();
        for(byte r:d) {
            System.out.println(r);
        }
        char e = '0';System.out.println("e is ["+p+"]");
        System.out.println(str.getBytes());
        System.out.println(new init_child(1).num);
        Super sup = new Sub();
        child.aa();
        System.out.println(sup.field);
        System.out.println(sup.getField());
    }

    @Test
    public void test(){

    }
}

class parent{
    protected static int num = 100;
    protected static void aa(){System.out.println("asdfas");}
    protected void say(){
        System.out.println("this is LXH.parent say");
    }
    protected void eat(){
        say();
//        System.out.println("this is LXH.parent eat");
    }
}

class child extends parent{

    public void getNum(){
        System.out.println("num is "+num);
    }
    public void changeNum(){
        num = 10;
    }

    @Override
    protected void say() {
        System.out.println("this is LXH.child say");
    }

//    @Override
//    protected void eat(){
//        System.out.println("this is LXH.child eat");
//    }
}
class son extends parent{
    public void getNum(){
        System.out.println("num is " + num);
    }
}

class init_parent{
    int num = getNum();
    private int getNum(){
        System.out.println("this is init'getNum");
        return 66;
    }

    public init_parent() {
        System.out.println("this is init inti function_moren");
    }

    public init_parent(int a){
        System.out.println("this is LXH.parent initfun_a");
    }
}

class init_child extends init_parent{
    public init_child(int a){
          //在导出类的构造器主体中,没有明确指定调用某个基类构造器,就会默认调用默认构造器,若某个类不存在默认构造器,编译器自动合成一个默认构造器。如果不存在默认构造器(即程序员自定义构造器代替了默认构造器),编译器就会报错。
    }
}

class Super{
    public int field = 0;
    public int getField(){
        return field;
    }
}
class Sub extends Super{
    public int field = 1;

    @Override
    public int getField() {
        return super.field;
    }

    public int getSuperField(){
        return this.field;
    }


}
class cup{
    HashMap aa[] = new HashMap[2];
    public int a;
    static{
        b = getB();
    }
    public static int b = getA();

    {
        System.out.println("before :"+b);
        b = 4;
        System.out.println("after :"+b);
        System.out.println(aa[0]);
    }

    public static int getB(){
        System.out.println("this is getB");
        return 2;
    }
    public static int getA(){
        System.out.println("this is getA");
        return 1;
    }
}