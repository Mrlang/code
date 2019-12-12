package Algorithm;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/8/22 using IDEA.
 */
/*给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
        区间中的最小数 * 区间所有数的和
        最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:*/
public class toutiao_2 {
    private static int[] nums;
    private static long res = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        nums = new int[length];
        for(int i=0; i<length; i++) {
            nums[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE,sum = 0;
        get(min, sum, 0, true);
        get(min, sum, 0, false);
        System.out.println(res);
    }

    private static void get(int min, int sum, int index, boolean flag){
        if(index >= nums.length)
            return;
        if(flag){
            sum += nums[index];
            min = nums[index] < min ? nums[index] : min;
            int multy = sum * min;
            res = multy > res ? multy : res;
        }
        get(min, sum, index+1, true);
        get(min, sum, index+1, false);
    }
}
