package Algorithm.SortAlgorithm_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Mr_liang on 2017/3/8 using IDEA.
 */
//TODO: 桶排序好像比较low，把数放进100，200，...800 的n个桶，每个桶里边分别依赖于归并或快速排序
public class tong {
    public static void main(String args[]) {
        int arr[] = new int[100];
        Random r = new Random(47);
        for(int i=0; i< arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        sort1(arr);
        prin(arr);
    }

    public static void sort1(int arr[]){
        int b = arr.length / 10;
        ArrayList l[] = new ArrayList[b];
        for(int i=0; i< l.length; i++) {
            l[i] = new ArrayList<Integer>();
        }

        for(int i=0; i< arr.length; i++) {
            int index = f(arr[i]);
            l[index].add(arr[i]);
        }

        for(int i=0; i< l.length; i++) {
            Collections.sort(l[i]);
        }

        int index = 0;
        for(int i=0; i< l.length; i++) {
            for(int j=0; j< l[i].size(); j++) {
                arr[index++] = (Integer) l[i].get(j);
            }
        }
    }

    public static int f(int a){
        return a/10;
    }

    public static void prin(int arr[]){
        for( int  str : arr) {
            System.out.println(str);
        }
    }

}
