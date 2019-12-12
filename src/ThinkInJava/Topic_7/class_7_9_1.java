package ThinkInJava.Topic_7;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_7_9_1 extends Insect{

    public class_7_9_1(){
        System.out.println("this is class_7_9_1.Main");
        System.out.println("k="+k);
        System.out.println("j="+j);
    }

    private static int x2 = returnInt("class_7_9_1.static x2 init");
    public static void main(String args[]) {
        System.out.println("class_7_9_1 constructor");
        new class_7_9_1();
    }
    private int k = returnInt("class_7_9_1.k init");

}

class Insect{
    private int i=9;
    protected int j;
    public int m;

    private  int n2 = returnInt("int n2");

    {
        m = returnInt("int m");
    }
    Insect(){
        System.out.println("i="+i+",j="+j);
        j=39;
    }
    private static int x1 = returnInt("static Insect.x1 init");
    static int returnInt(String s){
        System.out.println("this is returnInt:"+s);
        return 47;
    }


}
