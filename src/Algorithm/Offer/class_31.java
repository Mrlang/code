package Algorithm.Offer;

import org.junit.Test;

/**
 * Created by Mr_liang on 2017/8/13 using IDEA.
 */
//http://blog.csdn.net/derrantcm/article/details/46736967
//TODO: 数组中的最大连续和。求所有子数组的和的最大值。要求时间复杂度为O(n)。
//TODO:
//          用一个额外整型记录连续和(可以不是最大的，但一定要如实记录，但上一个的连续和是负数，这次可以清空这个整型从这次开始重新记录连续和)，
//         另一个额外整型记录最大和(当第一个整型的值大于本整型是，跟新记录最大和)
//TODO: 除了输出最大和的值之外，还要搞清楚需不需要被这几个连续的数输出来，要的话需要申请一个额外的list

public class class_31 {
    public static void main(String args[]){
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        // 解法1
        int max = Integer.MIN_VALUE;
        int curSum = Integer.MIN_VALUE;
        for (int i : arr) {
            if(curSum <= 0) {
                curSum = i;
            }else {
                curSum += i;
            }
            max = Math.max(curSum, max);
        }

        System.out.println(max);
    }

    @Test
    // 解法2
    public void test(){
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int max = arr[0];
        int sum = arr[0];
        for(int i=1; i<arr.length; i++) {
            int cur = arr[i];
            if(sum <= 0) {
                sum = cur;
            }else {
                sum += cur;
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }

    @Test
    //  错误的解法,虽然看着挺正确的
    public void test1(){
        int[] arr = {-7};
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i : arr) {
            if( curSum + i > 0 ) {
                curSum = curSum + i;
            }else {
                curSum = 0;
            }
            max = Math.max(curSum, max);

        }

        System.out.println(max);
    }
}
