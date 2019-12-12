package Algorithm.niuKe.array;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/7 using IDEA.
 */
public class exam {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int i = 2;
        BigDecimal big = new BigDecimal(num);
        double m = Math.pow(num, 1.0/i);
        while( m >= 2 ){
            if(!isInteger(m)){
                i++;
                m = Math.pow(num, 1.0/i);
                continue;
            }
            m= Math.round(m);
            if(isPrime((int)m)){
                System.out.println((int)m+" "+i);
                return;
            }
            i++;
            m = Math.pow(num, 1.0/i);
        }
        System.out.println("No");
    }

    @Test
    public static boolean isInteger(double num){
        long i = Math.round(num);
        double a = i - num;
        if(a < 0.00000000001)
            return true;
        else
            return false;

    }

    public static boolean isPrime(int num){
        if(num<2)  // is <2, not >2
            return false;
        else {
            for(int i=2; i<=Math.sqrt(num); i++){
                if( num%i == 0 )
                    return false;
            }
            return true;
        }

    }
}

//
//import java.util.Scanner;
//public class pinghunshu {
//    public static void Main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//}
//
//import java.util.Scanner;

//public class pinghunshu {
//    public static void Main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//                ans += x;
//            }
//        }
//        System.out.println(ans);
//    }
//}