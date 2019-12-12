package Algorithm.niuKe.Exam360;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/25 using IDEA.
 */
public class Main1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = new Integer(sc.nextLine());
        int total = 0;
        for(int i=0; i< length; i++) {
            String str = sc.nextLine();
            String[] input = str.split(" ");
            int temp = new Integer(input[0]) * new Integer(input[1]);
            total += temp;
        }

        System.out.println("0"+new DecimalFormat("#.000").format((double)total/100));
//        System.out.println(String.format("%.3f", (double)(120/100)));

    }
}
