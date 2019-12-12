package Algorithm.AlgorithmHomeWork.lesson_1;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QuickSort {
	public static int[] array;

	@Test
	public void test(){
	    array = new int[]{1,4,5,2,9,8,6,7,10,3};
	    sortArray();
        for (int i : array) {
            System.out.println(i);
        }
	}

	public static void main(String a[]) throws IOException{
		array = randomClass.datagenetare();				//生成2000个随机数

		long startTime=System.currentTimeMillis();   	//获取开始时间
		array = sortArray();							//实现快速排序
		long endTime=System.currentTimeMillis(); 		//获取结束时间


		OutputStream out = null;
		for (int aa: array) {							//打印结果并写入文件
			System.out.println(aa);
			out = new FileOutputStream("resultsQS.txt", true);
			out.write((aa+"\r\n").getBytes());
		}
		out.write(("程序运行时间： "+(endTime-startTime)+"ms").getBytes());
		out.close();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");


	}


	public static int[] sortArray(){
		int len = array.length;
		quicksort(0, len-1);
		return array;
	}
	
	public static void quicksort(int begin,int end){
		if(begin == end)
			return;
		int current = array[begin];
		int i = begin + 1, j = end;
		while(i<j){
			while(i <= end && array[i] <= current)
				i++;
			while(j >= begin && array[j] > current)
				j--;
			if(i < j) {
				swap(i,j);
				i++;
				j--;
			}
		}
		swap(j,begin);
		System.out.print("---" + j +"----,begin is " + begin +" ,end is "+ end +", ");
		System.out.println();
		if(j == 363)
			System.out.println(363);
		if(0 < j-1 && j-1 < array.length && begin <= j-1)
			quicksort(begin,j-1);
		if(0< j+1 && j+1 < array.length && j+1 <= end)
			quicksort(j+1,end);

	}
	
	public static void swap(int i, int j){
		int num = array[i];
		array[i] = array[j];
		array[j] = num;
	}
}
