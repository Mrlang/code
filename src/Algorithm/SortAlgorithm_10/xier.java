package Algorithm.SortAlgorithm_10;

/**
 * Created by Mr_liang on 2017/3/8 using IDEA.
 */

//http://www.codeceo.com/article/10-sort-algorithm-interview.html
//TODO: 还是有点复杂，间隔并不是1的插入排序，d每缩小一次都还插入排序一次
public class xier {
    public static void main(String args[]) {
        int[] arr = new int[]{3,5,1,2,6,8,7};
        shellSort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shellSort(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int d = arr.length / 2;
        while (d >= 1) {
            insertSort(arr, 2);
            d /= 2;
        }
    }

    public static void insertSort(int[] arr, int d){
        for(int i=d; i<arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            for(j=i-d; j>=0 && arr[j]>temp; ) {
                arr[j+d] = arr[j];
                j = j-d;
            }
            //TODO: 跟插入排序的注意点一样，前面循环后 j=j-d,现在需要加回来
            arr[j+d] = temp;
        }
    }


}
