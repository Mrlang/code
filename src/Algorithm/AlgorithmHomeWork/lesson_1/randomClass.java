package Algorithm.AlgorithmHomeWork.lesson_1;

import java.io.*;

public class randomClass {
	public static void  main(String a[]) throws IOException{
		File f = new File("./data.txt");
		FileOutputStream out = new FileOutputStream(f);
		String s = "";
		for(int i = 0; i < 2000; i++){
			int num = (int)(Math.random() * 10000);
			s = s + num + ",";

		}
		byte[] b = s.getBytes();
		out.write(b);
		out.close();

	}
	public static String[] readString() throws IOException {
		FileInputStream in = new FileInputStream("./data.txt");
		byte[] b = new byte[1024];
		String s = "";
		int len;
		String[] array;
		while ((len = in.read(b)) > 0){
			s = s + new String(b,0,len);
		}
		array = s.split(",");
		return array;
	}

	public static int[] datagenetare() throws IOException {
		int[] intArray = new int[15];
		String[] strArray = randomClass.readString();
		for (int i=0; i< 2000; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}
}
/*		程序结果:
		point 1--> point 1,length is 22
		point 1--> point 2,length is 2
		point 1--> point 3,length is 15
		point 1--> point 4,length is 27
		point 1--> point 5,length is 12
		point 1--> point 6,length is 25
		point 2--> point 1,length is 20
		point 2--> point 2,length is 22
		point 2--> point 3,length is 35
		point 2--> point 4,length is 25
		point 2--> point 5,length is 10
		point 2--> point 6,length is 30
		point 3--> point 1,length is 24
		point 3--> point 2,length is 4
		point 3--> point 3,length is 39
		point 3--> point 4,length is 14
		point 3--> point 5,length is 14
		point 3--> point 6,length is 10
		point 4--> point 1,length is MAX_LENGTH
		point 4--> point 2,length is MAX_LENGTH
		point 4--> point 3,length is MAX_LENGTH
		point 4--> point 4,length is MAX_LENGTH
		point 4--> point 5,length is MAX_LENGTH
		point 4--> point 6,length is MAX_LENGTH
		point 5--> point 1,length is MAX_LENGTH
		point 5--> point 2,length is MAX_LENGTH
		point 5--> point 3,length is MAX_LENGTH
		point 5--> point 4,length is 15
		point 5--> point 5,length is MAX_LENGTH
		point 5--> point 6,length is MAX_LENGTH
		point 6--> point 1,length is MAX_LENGTH
		point 6--> point 2,length is MAX_LENGTH
		point 6--> point 3,length is MAX_LENGTH
		point 6--> point 4,length is 4
		point 6--> point 5,length is 10
		point 6--> point 6,length is MAX_LENGTH

		Process finished with exit code 0
*/