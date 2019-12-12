package Algorithm.SortAlgorithm_10;

import org.junit.Test;

/**
 * Created by Mr_liang on 2016/11/27.
 */
public class HeapSortTest {
    private int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
    private int size = data.length;
    @Test
    public void run(){
        buildMapHeap(size-1);//将所有元素构造在最大堆里
        System.out.print("--------begin:------");
        for(int a : data){  System.out.print(a);  }        System.out.println();
        fetchMax();//一层一层,逐一取出堆顶最大元素放在数组最后,剩下的元素生成最大堆
        System.out.print("--------end:------");
        for(int a : data){  System.out.print(a);  }        System.out.println();
    }

    //构建最大堆     getLeft(i)=i*2+1<=lastIndex && getRight(i)=i*2+2<=lastIndex
    private void buildMapHeap(int lastIndex){
        for(int i=(lastIndex-1)/2; i>=0; i--)
            maxify(i);
    }

    /**
     * 将以i为根的子堆(无序)构建成最大堆
     * @param i 子堆的根节点
     */
    private void maxify(int i){
        int left = getLeft(i);
        int right = getRight(i);
//        System.out.println("("+ data[i]+ ")i is "+ i +", (" + data[left] +")left is "+ left + ", ("+ data[right] +")right is " + right);

        int maxIndex = i;
        //如果"data[left]>data[maxIndex]"放在左边作为第一个条件的话,可能left>data.length-1,会报nullPointer错误
        if( left<=size-1&& data[left]>data[maxIndex] )
            maxIndex = left;
        if( right<=size-1 && data[right]>data[maxIndex] )
            maxIndex = right;
        if( i!=maxIndex ){
            swap(i, maxIndex);
            maxify(maxIndex);//如果有位置交换,那么交换后,data[maxIndex]的值发生变化,以data[maxIndex]为根的堆现在最大值可能并不是data[maxIndex];在 3-2-1这个堆和2-8-7这个堆的根交换位置时就有这种情况
        }
    }

    private void fetchMax(){
        for(int i=data.length-1; i>0; i--){
            swap(0, i);
            size--;
            System.out.print("0 is "+data[0]+";i is "+i +";data[i] is" +data[i]+";last is "+data[i]+";");
            buildMapHeap(i-1);
            for(int a : data){  System.out.print(a);  }        System.out.println();
        }
    }

    private int getLeft(int i){
        return i*2+1;
    }

    private int getRight(int i){
        return i*2+2;
    }

    private void swap(int x, int y){
        int sum = data[x]+data[y];
        data[y] = sum - data[y];
        data[x] = sum - data[y];
    }



}
