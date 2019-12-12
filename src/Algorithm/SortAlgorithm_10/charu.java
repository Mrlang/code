package Algorithm.SortAlgorithm_10;

//TODO: 出过错误
public class charu {
    public static void main(String args[]) {
        Integer[] arr = new Integer[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        sort1(arr);
        prin(arr);
    }

    public static void sort1(Integer[] arr){
        int i,j;
        //每次只要i或j在for循环外部定义时一定要注意,最后一次循环完后还有一次i--,i++,j++,j--。for循环后还想使用i或j值的时候,一定要补回来
        for(i=1; i<arr.length; i++){
            int temp = arr[i];
            //必须是arr[j]>temp;不能用arr[j]>arr[i],因为当第一次比较时,arr[i]值还没变可以正确使用,然而如果arr[j]>arr[i],arr[i]值会变为arr[j],现在已经arr[i]不再是刚开始时选定的arr[i](即temp)值了,下一次比较必须和temp比较
            for(j=i-1; j>=0 && arr[j]>temp; j--){
                    arr[j+1] = arr[j];
            }
            //TODO: 会出错：上边每次循环后j--,所以要找到真正的位置必须+1复原。
            arr[j+1] = temp;

        }

    }

    public static void prin(Integer[] arr){
        for( int str : arr) {
            System.out.println(str);
        }
    }





}
