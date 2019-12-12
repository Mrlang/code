package Algorithm.niuKe.JD;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/7 using IDEA.
 */
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/7 using IDEA.
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = new Integer(sc.nextLine());
        char[] num1 = sc.nextLine().toCharArray();
        char[] num2 = sc.nextLine().toCharArray();
        int total = 0;
        for(int i=0; i<length; i++){
            if(num1[i] - num2[i] == 0)
                total += 0;
            else
                total += Math.pow(2, length-1-i);

        }
        System.out.println(total);
    }
}
