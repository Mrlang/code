package Algorithm.SortAlgorithm_10;

/**
 * Created by Mr_liang on 2017/3/8 using IDEA.
 */
public class guibing {
    public static void main(String args[]) {
        int[] arr = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        sortArray(arr, 0, arr.length-1);
        prin(arr);
    }


    //TODO: 不需要更多，只需要写这一个函数就可以往下递归了，main方法调用这个函数即可完成排序
    public static void sortArray(int[] arr,int begin ,int end){
        //TODO: 退出递归条件；和快排的二分子函数结束递归同样的条件
        if(begin>=end)
            return;

        int mid = (begin+end) /2 ;
        sortArray(arr, begin, mid);
        sortArray(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    //TODO: 有必要熟练
    public static void merge(int arr[], int begin, int mid, int end){
        int[] temparr = new int[end - begin + 1 ];
        int x=begin, y=mid+1, z=0;
        while(x<=mid && y<=end) {
            if (arr[x] <= arr[y])
                temparr[z++] = arr[x++];
            //TODO: 记得每一次填补大数组，把小数组index加一之后，还要把大数组currentIndex 加一。
            else
                temparr[z++] = arr[y++];
        }

        for(int i=y; i<=end; i++)
            temparr[z++] = arr[i];

        for(int i=x; i<=mid ; i++)
            temparr[z++] = arr[i];

        for(int i=0; i< temparr.length; i++) {
            arr[begin+i] = temparr[i];
        }
    }

    public static void prin(int[] arr){
        for( int str : arr) {
            System.out.println(str);
        }
    }

}

