package Algorithm.niuKe.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/23 using IDEA.
 */
public class kind {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = new Integer(sc.nextLine());
//        String allstr[] = new String[length];
        ArrayList list = new ArrayList<String>();
//        for(int i=0; i<length; i++){
//            allstr[i] = sc.nextLine();
//        }
        for(int i=0; i<length; i++) {
            System.out.println("i is "+i);
            char[] chars = sc.nextLine().toCharArray();
            Arrays.sort(chars);
//            System.out.println(new String(chars));
            if(!list.contains(new String(chars)))
                list.add(new String(chars));
        }

        getRes(list);
    }

    public static void getRes(ArrayList<char[]> list){
        System.out.println(list.size());
    }
    @Test
    public void test(){
        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a.equals(b));
    }
}


