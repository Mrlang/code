package DoDoDo.sword_point;

import Algorithm.SortAlgorithm_10.kuaisu_new;
import org.junit.Test;

/**
 * Created by Mr_liang on 2017/8/13 using IDEA.
 */

//输入n个整数，找出其中最小的k个数。
//例如输入4 、5 、1、6、2、7、3 、8 这8 个数字，则最小的4 个数字是1 、2、3 、4
public class class_30 {
    @Test
    public void test(){
        int[] arr = new int[]{4,5,6,2,7,3,8,0,1 };
        int k = 4;
        resolve(arr, k);
    }

    public static void main(String[] args){
        int[] arr = new int[]{4 ,5 ,1,6,2,7,3,8 };
        int k = 4;
        int[] res = new int[k];
        findMinK(arr, res);
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }

    //resolve1: 通过堆的方法,查找最小的k个数
    public static void findMinK(int[] arr, int[] res){
        for (int i=0; i<res.length; i++){
            res[i] = arr[i];
        }
        buildHeap(res);

        for(int i=res.length; i<arr.length; i++) {
            int max = arr[0];
            if(arr[i] < max){
                res[0] = arr[i];
                buildHeap(res);
            }
        }
    }

    public static void buildHeap(int[] res){
        for(int i=res.length-1; i>=0; i--) {
            changeChildHeapByIndex(res, i);
        }
    }

    // 将以res[index]为根节点的子树关键成最大堆
    public static void changeChildHeapByIndex(int[] res, int index){
        int leftNodeIndex = index*2 + 1;
        int rightNodeIndex = index*2 + 2;
        int max = res[index];
        int changedIndex = index;
        if(leftNodeIndex < res.length && res[leftNodeIndex] > res[index]){
            changedIndex = leftNodeIndex;
        }
        if(rightNodeIndex < res.length && res[rightNodeIndex] > res[index]){
            changedIndex = rightNodeIndex;
        }

        if(changedIndex != index){
            swap(res, changedIndex, index);
            changeChildHeapByIndex(res, changedIndex);
        }
    }

    public static void swap(int[] res, int x, int y){
        int sum = res[x] + res[y];
        res[y] = res[x];
        res[x] = sum - res[x];
    }

    //resolve2:O(n)复杂度。 若返回的分界点下标为k，则其左边的k个数都比这个分界点小
    public void resolve(int[] input,int k) {
        //模仿class_29
        int begin = 0;
        int end = input.length - 1;

        int returnIndex = kuaisu_new.partition2(input, begin, end);
        while(returnIndex != k) {
            if(returnIndex > k) {
                //TODO 这个必须更新end值，并传进方法里,不能直接使用returnIndex = kuaisu_new.partition2(input, begin, returnIndex-1);
                end = returnIndex-1;
                returnIndex = kuaisu_new.partition2(input, begin, end);
            }else {
                begin = returnIndex + 1;
                returnIndex = kuaisu_new.partition2(input, begin, end);
            }
        }

        for(int i=0; i<k; i++) {
            System.out.println(input[i]);
        }

    }


}
