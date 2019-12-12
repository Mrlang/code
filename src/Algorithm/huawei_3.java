package Algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/9/13 using IDEA.
 */
public class huawei_3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int index = Integer.valueOf(sc.nextLine());
        NumObj[] objs = new NumObj[strs.length];
        for(int i=0; i<strs.length; i++) {
            int a = Integer.valueOf(strs[i]);
            int b;
            if(strs[i].length() >= 3)
                b = Integer.valueOf(strs[i].substring(strs[i].length()-3));
            else {
                b = a;
            }
            objs[i] = new NumObj(a, b);
        }

        handle(objs, index);


    }

    public static void handle(NumObj[] objs, int index){
        Arrays.sort(objs);
        System.out.println(objs[index-1].value);
    }

//    @Test
//    public void test(){
//        String s = "123456";
//        System.out.println(s.substring(s.length()-3));
//    }
}

class NumObj implements Comparable<NumObj>{
    public int value;
    public int tail;

    public NumObj(int value, int tail) {
        this.value = value;
        this.tail = tail;
    }


    @Override
    public int compareTo(NumObj o) {
        if(this.tail == o.tail)
            return 0;
        if(this.tail > o.tail)
            return 1;
        if(this.tail < o.tail)
            return -1;

        return 0;
    }
}