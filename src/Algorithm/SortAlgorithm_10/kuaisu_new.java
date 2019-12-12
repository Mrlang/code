package Algorithm.SortAlgorithm_10;

import org.junit.Test;

import static Algorithm.SortAlgorithm_10.kuaisu.swap;

/**
 * Created by wangliang01 on 2019/6/24 using IDEA.
 */
public class kuaisu_new {
    @Test
    public void test(){
        int[] array = new int[]{4,5,2,9,8,6,7,10,3,1};
        quickSort(array, 0, array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] array, int begin, int end) {
        if(begin >= end)
            return;
        int middle = partition2(array, begin, end);
        quickSort(array, begin, middle-1);
        quickSort(array, middle + 1, end);
    }

    public int partition(int[] array, int begin, int end) {
        int key = array[begin];
        int left = begin+1;
        int right = end;
        while(left < right) {
            while (array[left] <= key) {
                left++;
            }

            while(array[right] >= key) {
                right--;
            }

            if(left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        swap(array, begin, right);
        return right;
    }

    public static int partition2(int array[], int begin, int end) {
        int key = array[end];
        int p = begin - 1;
        for(int  index = begin; index < end; index++) {
            if(array[index] < key) {
                p++;
                swap(array, p, index);
            }
        }

        int middle = p + 1;
        swap(array, middle, end);
        return middle;
    }
}
