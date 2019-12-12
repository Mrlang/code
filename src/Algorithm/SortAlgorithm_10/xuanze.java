package Algorithm.SortAlgorithm_10;

//出过错误
public class xuanze {
    public static void main(String args[]) {
        int[] arr = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        sort1(arr);
        prin(arr);
    }

    public static void sort1(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            //TODO:刚开始时设最小值为arr[i],那么minIndex必须是i.
            int min = arr[i];
            int minIndex = i;
            //TODO:要注意记录最小项的下标,而不是直接swap(arr,i,j-1)
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        if(i==j)    return;
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
