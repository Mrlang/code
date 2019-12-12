package Algorithm.SortAlgorithm_10;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Mr_liang on 2017/3/8 using IDEA.
 */

//TODO : 出过错误
public class kuaisu {

    public static void  main(String args[]) {
        int[] intArray = new int[]{1,9,8,7,4,5,3,2,6};

        sort(intArray);
        for(int i=0; i<intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void sort(int[] arr){
        if(arr == null)
            System.out.println("error");
        else
            partition(arr, 0, arr.length-1);
    }

    public static void partition(int arr[], int begin, int end){
        //TODO: 退出递归条件：长度为0个或1个时，就不要再排了；
        if(begin >= end)
            return;

        Random random = new Random(45);
        // 在[end, begin]中产生一个随机数
        int randomIndex = random.nextInt(end - begin ) + begin;
        int pivot = arr[randomIndex];
        int leftIndex = begin;
        int rightIndex = end;
        //TODO: 重要条件，不需要<=条件，因为不可能left和right同时指向一个数(这个数满足<=point， 又满足>point)，肯定有一个指针得再划一次
        while(leftIndex < rightIndex){
            while(arr[leftIndex] <= pivot)
                leftIndex++;

            while(arr[rightIndex] >= pivot)
                rightIndex--;

            //TODO: 重要条件
            if( leftIndex < rightIndex ) {
                swap(arr, leftIndex, rightIndex);
                //TODO: 当使用randomIndex作为分界点时，该分界点有可能在右边部分，会被swap左半部分，swap后改好，方便最后把分界点换到中间
                if(rightIndex == randomIndex)
                    randomIndex = leftIndex;
            }

        }
        //TODO: 赖以循环的条件就是arr[leftIndex]<=point,所有每当循环退出拿到leftIndex时,leftIndex指定的必定是不符合<=point条件的点，所以要减1
        //swap(arr, randomIndex, leftIndex-1);
        //TODO: 或者用不符合条件的rightIndex
        //TODO: 注意更换randomIndex,分界点可能被换过位置
        swap(arr, randomIndex, rightIndex);
        partition(arr, begin, randomIndex-1);
        partition(arr, randomIndex+1, end);
    }

    public static void swap(int arr[], int x, int y){
        int temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }

    @Test
    public void a(){


    }

}
