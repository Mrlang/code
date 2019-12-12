package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/8/29 using IDEA.
 */
public class qq_tes {
    private static int[] nums = new int[4];
    private static List<Integer>[] lists = new List[]{null, new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>()};
    private static int min = 1;
    private static int max;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++) {
            nums[i] = sc.nextInt();
        }
        max = (int)(Math.pow(2, nums[0]));
        int rootValue = (max+1)/2;
        for(int i=1; i<4; i++) {
            find(i, min , max);
        }

        System.out.println(getRes());
    }

    public static void find(int i, int min, int max){
        int cmpValue = (min+max)/2;
        if(cmpValue == nums[i])
            lists[i].add(cmpValue);

        if(nums[i] > cmpValue){
            lists[i].add(cmpValue);
            find(i, cmpValue+1,max);
        }

        if(nums[i] < cmpValue){
            lists[i].add(cmpValue);
            find(i,  min, cmpValue-1);
        }

    }

    public static int getRes(){
        int minSize = lists[1].size() < lists[2].size() ? lists[1].size()<lists[3].size() ? lists[1].size() : lists[3].size() : lists[2].size()<lists[3].size() ? lists[2].size() : lists[3].size();

        for(int i=0; i<minSize; i++) {
            if(i == minSize-1)
                return lists[1].get(i);
            if(lists[1].get(i) == lists[2].get(i) && lists[2].get(i) == lists[3].get(i)){

            }else {
                return lists[1].get(i-1);
            }
        }
        return  0;
    }


}
