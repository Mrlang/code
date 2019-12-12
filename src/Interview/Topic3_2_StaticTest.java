package Interview;

/**
 * Created by Mr_liang on 2016/12/6.
 */
public class Topic3_2_StaticTest {
    public static int a;

    static {
        System.out.println("at the begining:");
        print();
    }

    static void print(){
        System.out.println("asfasfd");
    }

    static {
        System.out.println("static stack : a is "+a);
    }

    public static void main(String args[]){
        System.out.println("Main function: a is "+ a);
        print();
    }

    static {
        a = 666;
        System.out.println("static stack2: now a is "+a);
    }
}
