package Algorithm.SortAlgorithm_10;

import java.util.Random;

/**
 * Created by Mr_liang on 2017/3/7 using IDEA.
 */
//TODO: 掌握优化方法
public class maopao {
    public static void main(String args[]) {
        int[] arr = new int[10000];
        Random r = new Random(47);
        for(int i=0; i< 10000; i++) {
            arr[i] = r.nextInt();
        }
        long l1= System.currentTimeMillis();


        sort1(arr);
        prin(arr);
        System.out.println(System.currentTimeMillis()-l1);
    }

    public static void sort1(int[] arr){
        for(int i=0; i< arr.length-1 ; i++)
            for(int j=arr.length-1; j>i ; j--)
                if(arr[j] < arr[j-1])
                    swap(arr, j, j-1);


    }

    public static void sort2(int[] arr){
        for(int i=0; i< arr.length-1; i++)
            for(int j=i+1; j< arr.length; j++)
                if(arr[i] > arr[j])
                    swap(arr, i,j);

    }

    public static void sort1_youhua(int[] arr){
        boolean needSort = true;
        for (int i=0; i<arr.length-1 && needSort; i++) {
            needSort = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    needSort = true;
                }
            }
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void prin(int[] arr){
        for( int str : arr) {
            System.out.println(str);
        }
    }
}
