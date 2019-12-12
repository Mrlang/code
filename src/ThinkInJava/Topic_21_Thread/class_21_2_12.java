package ThinkInJava.Topic_21_Thread;

/**
 * Created by Mr_liang on 2017/2/19 using IDEA.
 */
public class class_21_2_12 {
    public static void main(String args[]) throws Exception{
        Object o = new ResponseUI();
        int read = System.in.read();
        System.out.println("read is "+read);
        System.out.println(UnResponseUI.d);
    }
    

}
class UnResponseUI {
    public  static volatile double d =1;
    public UnResponseUI() throws Exception{
        while (d > 0){
            d = d + (Math.E + Math.PI) /d;
        }
        int read = System.in.read();
        System.out.println("read is "+read);
    }
}

class ResponseUI extends Thread{
    public static volatile double d =1;
    public ResponseUI(){
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while(true) {
            d = d + (Math.E + Math.PI) /d;
        }
    }
}