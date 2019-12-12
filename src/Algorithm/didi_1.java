package Algorithm;

/**
 * Created by Mr_liang on 2017/8/26 using IDEA.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class didi_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        if(in.hasNextLine())
            str = in.nextLine();
        String[] strArr = str.split(" ");
        int currentSum = 0;
        int max = 0;
        for( String s : strArr) {
            currentSum += Integer.valueOf(s);
            if(currentSum > max)
                max = currentSum;
            if(currentSum < 0)
                currentSum = 0;
        }
        System.out.print(max);

    }
}



