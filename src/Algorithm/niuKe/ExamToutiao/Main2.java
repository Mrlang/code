package Algorithm.niuKe.ExamToutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/30 using IDEA.
 */
public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] lengthstring = sc.nextLine().split(" ");
        int[] lengths = new int[]{new Integer(lengthstring[0]), new Integer(lengthstring[1])};
        String[] nums1 = sc.nextLine().split(" ");
        String[] nums2 = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<lengths[1]; i++){
            String[] mm = sc.nextLine().split(" ");
            int a=0;
            for(int j=0; j<lengths[0]; j++) {
                if (new Integer(nums1[j]) >= new Integer(mm[0]) && new Integer(nums2[j]) >= new Integer(mm[1]))
                    a++;
            }
            list.add(a);
        }
        for( int str : list) {
            System.out.println(str + " ");
        }
    }
}
