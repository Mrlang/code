package Algorithm.niuKe.ExamToutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/30 using IDEA.
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[n];
        int shangsheng=0,begin=0,xiajiang=0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i< nums.length; i++) {
            nums[i] = new Integer(strs[i]);
        }
        int pre = nums[0];
        for(int i=1; i< n; i++) {
            if(nums[i] > pre){
                if(xiajiang>0) {
                    map.put(begin, begin + shangsheng + xiajiang);
                    begin = i-1;
                    shangsheng=1;
                    xiajiang=0;
                }
                else
                    shangsheng++;
            }
            else{
                if(i-1==begin){
                    begin++;
                    shangsheng=0;
                    xiajiang=0;
                }
                else{
                    if(shangsheng>0)
                        xiajiang++;
                }
            }
            if(i==n-1 && shangsheng>0 && xiajiang>0){
                map.put(begin, begin + shangsheng + xiajiang);
            }
            pre = nums[i];

        }

        int maxLength = 0;
        Map.Entry en = null;
        if(map.size()==0){
            System.out.println("-1 -1");
            return;
        }
        else{
            for( Map.Entry entry: map.entrySet()) {
                int temp =  (Integer)(entry.getValue()) - (Integer)(entry.getKey());
                maxLength = temp>maxLength ? temp : maxLength;
                en = entry;
            }
        }
        if(en!=null)
            System.out.println(en.getKey() + " "+ en.getValue());


    }
}
