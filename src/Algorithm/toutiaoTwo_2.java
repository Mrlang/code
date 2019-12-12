package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/10/17 using IDEA.
 *
 * 一共有n个房间，现在从第a个房间把所有人取出来，从a+1房间开始循环每个房间放进去一个人。
 * 给出最后放完时，第1个房间到底n个房间的人数，和最后一个人进入了哪个房间
 * 求刚开始每个房间有几人，哪个房间的人被取了出来
 *
 */

public class toutiaoTwo_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String line1[] = sc.nextLine().split(" ");
        int end = Integer.valueOf(line1[1]);
        int n = Integer.valueOf(line1[0]);
        String[] line2 = sc.nextLine().split(" ");
        int[] nums = new int[n+1];
        nums[0]=0;
        for(int i=1; i<n+1; i++) {
            nums[i] = Integer.valueOf(line2[i-1]);
        }

        int person = 0;
        int[] oldums = Arrays.copyOf(nums, nums.length);
        for(int begin=1; begin<=n; begin++){
            //TODO: 单次循环结束后，第二次循环再开始时，一定要注意查看在循环体中用到的变量是否经过了修改，修改过的话查看是否需要在开头部分进行复原
            nums = Arrays.copyOf(oldums, oldums.length);
            person = 0;
            //END 对用到的变量复原完毕

            if(begin!=end){
                if(end < begin){
                    for(int m=1; m<=end; m++) {
                        nums[m]--;
                        person++;
                    }
                    for(int m=begin+1; m<=n; m++){
                        nums[m]--;
                        person++;
                    }
                }else{
                    for(int m=begin+1; m<=end; m++){
                        nums[m]--;
                        person++;
                    }
                }
            }
            int[] sortnums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortnums);
            int min = sortnums[1];
            System.out.println("min is "+min+", nums[] is " + nums[begin]);
            if(nums[begin] != min)
                continue;
            for(int q=1; q<=n; q++) {
                if(q == begin){
                    if(q==n){
                        System.out.print(min*n+person);
                    }else {
                        System.out.print(min*n+person + " ");

                    }
                }
                else {
                    if(q == n){
                        System.out.print(nums[q] - min);
                    }else {
                        System.out.print(nums[q] - min + " ");
                    }
                }
            }
            System.out.println();
        }


    }
}
