package ThinkInJava.Topic_6;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
class noPackage1 {
    public static void main(String args[]){
        noPackage2 p = new noPackage2();
        p.g();
    }
    public void f() {
        System.out.println("this is noPackage1");
    }
}
