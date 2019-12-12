package Algorithm.SortAlgorithm_10;

/**
 * Created by Mr_liang on 2017/3/8 using IDEA.
 */
//TODO: 考过，排序四六级分数，那就有明确范围0-750
public class jishuqi {
    public static void main(String args[]) {
        int[] arr = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        sort1(arr);
        prin(arr);
    }

    public static void sort1(int arr[]){
        //TODO : 这里求数组中的最大值是getMax(arr),那么count数组的最大下标就是getMax(arr),count数组的长度应该是getMax(arr)+1
        int length = getMax(arr) + 1;
        int count[] = new int[length];
        //TODO: 创建一个0-750的数组，用下标记录每一个分数，值记录每一个分数出现的次数
        for(int i=0; i< arr.length; i++) {
            int value = arr[i];
            count[value] ++;
        }
        int p = 0;
        for(int i=0; i< count.length; i++) {
            for(int j=0; j< count[i]; j++) {
                arr[p++] = i;
            }
        }
    }


    public static int getMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void prin(int[] arr){
        for( int str : arr) {
            System.out.println(str);
        }
    }
}
