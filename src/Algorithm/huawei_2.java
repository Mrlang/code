package Algorithm;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by Mr_liang on 2017/9/13 using IDEA.
 */
public class huawei_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        IP[] ips = new IP[4];
        for(int i=0; i<ips.length; i++) {
            ips[i] = new IP(sc.nextLine());
        }

        handle(ips);
    }
    @Test
    public void test(){


//        if("a" == new Object(){
//            @Override
//            public String toString() {
//                System.out.print("chang");
//                return "b";
//            }
//        }.toString()
//                ){
//            System.out.print("chang");
//        }else{
//            System.out.println("you");
//        }
        Integer[] arr = new Integer[2];
        int count = 0;
        for(Integer i: arr) {
            i = count++;
        }
        for(Integer i: arr) {
            System.out.println(i);
        }
    }
    public static void handle(IP[] ips){
        if( ips[2].compareTo(ips[1]) > 0 || ips[3].compareTo(ips[0]) < 0 ){
            System.out.println("No Overlap IP");
        }else {
            System.out.println("Overlap IP");
        }
    }

}

class IP implements Comparable<IP>{
    public String value;

    public IP(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(IP o) {
        if(this.value.equals(o.value))
            return 0;

        String[] anums = this.value.split("\\.");
        String[] bnums = o.value.split("\\.");
        for(int i=0; i<4; i++) {
            if(anums[i].compareTo(bnums[i]) >= 0){
            }else {
                return -1;
            }
        }
        return 1;
    }
    

    
}
