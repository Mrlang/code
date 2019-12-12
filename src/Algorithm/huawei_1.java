package Algorithm;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/9/13 using IDEA.
 */
public class huawei_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int oldNum = sc.nextInt();
        hanlde(oldNum);
    }

    public static void hanlde(int oldNum){
        char[] oldChars = String.valueOf(oldNum).toCharArray();
        if(oldNum < 0){
            System.out.println(oldChars.length - 1);
            System.out.print("-" + oldChars[1] +" ");
            for(int i=2; i<oldChars.length-1; i++) {
                System.out.print(oldChars[i] + " ");
            }
            System.out.println(oldChars[oldChars.length-1]);
            System.out.print("-");
            for(int i=oldChars.length-1; i>=1; i--) {
                System.out.print(oldChars[i]);
            }
        }else {
            System.out.println(oldChars.length);
            for(int i=0; i<oldChars.length-1; i++) {
                System.out.print(oldChars[i] + " ");
            }
            System.out.println(oldChars[oldChars.length-1]);
            for(int i=oldChars.length-1; i>=0; i--) {
                System.out.print(oldChars[i]);
            }
        }

    }
}
