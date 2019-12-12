package Algorithm.niuKe.ExamQuNa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/1 using IDEA.
 */
public class Main_3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();

        qwe(a, b, c);
    }

    public static void qwe(String a, String b, String dict){
        String words[] = dict.split(" ");
        ArrayList<String> list = new ArrayList<>();
        list.add(a);
        for (int i = 0; i<a.length (); i++){
            if (a.charAt(i) != b.charAt(i)) {
                for (int j = 0; j<words.length; j++){
                    if (words[j].charAt(i) == b.charAt(i)) {
                        list.add(words[j]);
                        a = words[j];
                        break;
                    }
                }
            }
        }

        System.out.println(list.size());


    }


}
