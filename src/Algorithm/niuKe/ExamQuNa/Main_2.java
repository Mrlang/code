package Algorithm.niuKe.ExamQuNa;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/1 using IDEA.
 */
public class Main_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String strs = null;
        int[] nums = null;
        while(sc.hasNextLine()) {
            strs = sc.nextLine();
            if(strs.equals(""))
                break;
            prin(strs);
        }

    }

    public static int[] change(String[] arr){
        int nums[] = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = new Integer(arr[i]);
        }
        arr = null;
        return nums;
    }

    public static void prin (String str) {
        HashMap map=new HashMap();
        int i=0;
        for(char c='a';c<='z';c++){
            map.put(c,i++);
        }

        int sum=0;
        int len=str.length();
        for(int j=len-1;j>=0;j--){
            sum+=((int)map.get(str.charAt(j)))*Math.pow(26,len-1-j);
        }
        System.out.println(sum);
    }
}

