package Algorithm.AlgorithmHomeWork.lesson_1;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class InsertionSort {
	@Test
	public void test(){
		System.out.println(System.currentTimeMillis());
	}
	public static void main(String a[]) throws IOException{
		int[] a1 = {89,45,68,90,29,34,17};
		a1 = randomClass.datagenetare();				//生成2000个随机数

		long startTime=System.currentTimeMillis();   	//获取开始时间
		a1 = sortArray(a1);								//实现插入排序
		long endTime=System.currentTimeMillis(); 		//获取结束时间

		OutputStream out = null;
		for(int i=0;i<a1.length;i++) {					//打印出结果
			System.out.println(a1[i]);
			out = new FileOutputStream("resultsQS.txt", true);
			out.write((a1[i]+"\r\n").getBytes());
		}
		out.write(("程序运行时间： "+(endTime-startTime)+"ms").getBytes());
		out.close();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		
	}
	public static int[] sortArray(int[] array){
		int len = array.length;
		int current,compareWithIndex;
		for(int i=1;i<len;i++) {
			current = array[i];
			compareWithIndex = i-1;
			while( (compareWithIndex>0 || compareWithIndex==0) && array[compareWithIndex] > current) {
				System.out.println("index is " + compareWithIndex + ","+ array[compareWithIndex] + ", "+ array[compareWithIndex+1]);
				array[compareWithIndex+1] = array[compareWithIndex];
				compareWithIndex--;
			}
			array[compareWithIndex+1] = current;
		}
		return array;
	}


}
