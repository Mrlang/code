package Algorithm;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/8/26 using IDEA.
 */
public class didi_2 {
    private static int k,res;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");
        k = in.nextInt();
        int nums[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.valueOf(arr[i]);
        }
        res = fun(nums, 0, arr.length - 1);
        if( k >= nums.length || k <0){
            System.out.println("error");
            return;
        }
        System.out.println(res);
    }
    private static int fun(int[] arr, int begin, int end){
        if(begin >= end)
            return arr[begin];

        int pointIndex = begin;
        int point = arr[begin];
        int leftIndex = begin+1;
        int rightIndex = end;
        while(leftIndex < rightIndex) {
            while (arr[leftIndex] <= point)
                leftIndex++;
            while (arr[rightIndex] > point)
                rightIndex--;
            if(leftIndex < rightIndex)
                swap(arr, leftIndex, rightIndex);
        }
        swap(arr, leftIndex-1, pointIndex);
        if(leftIndex-1 == arr.length - k)
            return arr[leftIndex-1];
        if(leftIndex-1 < arr.length - k)
            return fun(arr, leftIndex, end);
        else
            return fun(arr, begin, leftIndex-2);
    }

    private static void swap(int[] arr, int x, int y){
        int sum = arr[x] + arr[y];
        arr[y] = arr[x];
        arr[x] = sum - arr[x];
    }

}
