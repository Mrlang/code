package Algorithm.niuKe.WangYi_Exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/25 using IDEA.
 * 魔术手环问题
 */
public class WangYi_3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int length = new Integer(line1[0]);
        int k = new Integer(line1[1]);
        String[] stringNum = sc.nextLine().split(" ");
        int[] allnums = getNumArray(stringNum);
        allnums = getRes(length, k, allnums);
        for(int i=0; i< length-1; i++) {
            System.out.print(allnums[i]+" ");
        }
        System.out.print(allnums[length-1]);
    }

    public static int[] getNumArray(String[] stringNum){
        int[] nums = new int[stringNum.length];
        for(int i=0; i< stringNum.length; i++) {
            nums[i] = new Integer(stringNum[i]);
        }

        return nums;
    }

    public static int[] getRes(int length, int k, int[] old){
        int[] nums_a = new int[length];
        for(int i=0; i< k; i++) {
            for(int index=0; index< length; index++) {
                if(index<length-1) {
                    int temp  = old[index] + old[index + 1];
                    nums_a[index] = temp >= 100 ? temp%100 : temp;
                }
                else {
                    int temp = old[index] + old[0];
                    nums_a[index] = temp>= 100 ? temp%100 : temp;
                }
            }
            old = nums_a;
            //现在两个同时指向nums_a的数组,必须把nums_a再指向别处,负责待会nums_a[index] = 1+1;是就会改变old的值。
            nums_a = new int[length];
        }
        return old;
    }
}
