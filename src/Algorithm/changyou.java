package Algorithm;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/9/17 using IDEA.
 */
public class changyou {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int count = Integer.valueOf(sc.nextLine());
        String dataString[] = sc.nextLine().split(" ");
        int page = new Integer(sc.nextLine());
        int pageSize = new Integer(sc.nextLine());
        int[] data = new int[dataString.length];
        for( int i=0; i<dataString.length; i++) {
            data[i] = Integer.valueOf(dataString[i]);
        }

        int begin = page * pageSize;
        if(begin >= data.length) {
            System.out.print("超过分页范围");
            return;
        }

        for(int index=begin; index<begin+pageSize; index++) {
            if(index < data.length)
                System.out.println(data[index]);
        }
    }
}
