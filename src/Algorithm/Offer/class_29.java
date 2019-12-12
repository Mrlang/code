package Algorithm.Offer;

import org.junit.Test;

import static Algorithm.SortAlgorithm_10.kuaisu.swap;

/**
 * Created by wangliang01 on 2019/6/22 using IDEA.
 * 数组中出现次数超过一半的数字
 */
public class class_29 {
    @Test
    public void test(){
        int[] array = new int[]{1,2,2,2,3};
        System.out.println(run2(array));
        System.out.println(run2_2(array));
    }

    //resolve1: 利用快速排序的分区方法 o(n)
    //如果存在,则这个数字一定是数组的中位数
    //先找出中位数,然后判断中位数出现的次数是否真的超过一半
    public boolean run1(int[] array) {
        int begin = 0;
        int end  = array.length-1;
        int middle = array.length >> 1;
        int returnIndex = partition2(array, begin, end);
        while(returnIndex != middle) {
            if(returnIndex > middle) {
                //TODO 这个必须更新end值，并传进方法里,不能直接使用returnIndex = partition2(array, begin, returnIndex-1);
                end = returnIndex-1;
                returnIndex = partition2(array, begin, end);
            }else {
                begin = returnIndex+1;
                returnIndex = partition2(array, begin, end);
            }
        }

        return checkResult(array, returnIndex);
    }

    //resolve2: 利用计数器的增减  o(n)
    public boolean run2(int[] array) {
        int count = 0;
        Integer currentNum = null;
        for (int i : array) {
            if(currentNum == null) {
                currentNum = i;
                count++;
            }else if(currentNum == i) {
                count++;
            } else if (currentNum != i){
                count--;
                if(count == 0) {
                    currentNum = null;
                }
            }
        }

        return checkResult2(array, currentNum);
    }

    public boolean run2_2(int array[]) {
        int count = 0;
        Integer curNum = null;
        for (int i : array) {
            if(count == 0) {
                curNum = i;
                count++;
            }else {
                if(curNum == i) {
                    count++;
                }else{
                    count--;
                    if(count == 0){
                        curNum = null;
                    }
                }
            }
        }
        return checkResult2(array, curNum);
    }

    private boolean checkResult(int[] array, int returnIndex) {
        int key = array[returnIndex];
        int count = 0;
        for (int i : array) {
            if(i == key) {
                count++;
            }
        }
        if(count > array.length /2) {
            return true;
        }
        return false;
    }

    private boolean checkResult2(int[] array, Integer i) {
        //没有能够最后把count设为1,把currentNum设为非空的数字
        if(i == null) {
            return false;
        }
        int count = 0;
        for (int a : array) {
            if(a == i) {
                count++;
            }
        }
        if(count > array.length >> 1) {
            return true;
        }
        return false;
    }

    public int partition2(int array[], int begin, int end) {
        int key = array[end];
        int p = begin - 1;
        for(int  index = begin; index < end; index++) {
            if(array[index] < key) {
                p++;
                if(p != index) {
                    swap(array, p, index);
                }
            }
        }

        int middle = p + 1;
        swap(array, middle, end);
        return middle;
    }
}
