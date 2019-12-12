package ThinkInJava.Topic_7;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_7_2 {
    public static void main(String args[]) {
        System.out.println("this is 7.2");
    }
}

class A{
    public static void main(String args[]){
        System.out.println("this is A.Main()");
        if(args.length > 0)
            System.out.print(" arg[0] is "+args[0]);
        B.main(new String[]{"1"});
    }
}

class B{
    public static void main(String args[]){
        System.out.println("this is B.Main()");
        if(args.length > 0)
            System.out.print(" arg[0] is "+args[0]);
    }
}
