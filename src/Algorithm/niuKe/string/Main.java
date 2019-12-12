package Algorithm.niuKe.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/23 using IDEA.
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        String allStr[] = getAllString(N);
    }

    public static void getRes(){

    }

    public static String[] getAllString(int N){
//        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        ArrayList<char[]> list = new ArrayList<char[]>();
        char letters[] = new char[26];

        for(char c='A'; c<='Z'; c++){
            letters[index++] = c;
        }

        index=0;
        while( N>index++ ) {
            for(int i=0;i<26; i++){
//                if(list.get())
            }
        }

        return null;
    }
}
