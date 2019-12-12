package Algorithm.niuKe.numberList;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/23 using IDEA.
 */
public class pinghunshu {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        getRes(num);
    }

    public static void getRes(int num){
        char[] str = new Integer(num).toString().toCharArray();
        int length = str.length;
        for(int x=1;x<length;x++){
            int i=1,j=length-1;
            int total1=str[0]-'0',total2=1;
            while (i<x || j>=x){
                if(i<x)
                    total1 *= (str[i++]-'0');
                if(j>=x)
                    total2 *= (str[j--]-'0');
            }
            if(total1 == total2) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}


