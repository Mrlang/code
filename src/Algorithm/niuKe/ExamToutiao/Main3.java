package Algorithm.niuKe.ExamToutiao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/30 using IDEA.
 6 3
 An algorithm is an effective method that can be expressed within a finite amount of space and time
 Starting from an initial state and initial input the instructions describe a computation
 That when executed proceeds through a finite number of successive states
 Eventually producing output and terminating at a final ending state
 The transition from one state to the next is not necessarily deterministic
 Some algorithms known as randomized algorithms incorporate random input
 Next to the transition
 Wormhole infinite time and space
 The transition from one state to the next is not necessarily deterministic


 The transition from one state to the next is not necessarily deterministic
 An algorithm is an effective method that can be expressed within a finite amount of space and time
 The transition from one state to the next is not necessarily deterministic
 */
public class Main3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String lengthstr[] = sc.nextLine().split(" ");
        int[] lengths = new int[]{new Integer(lengthstr[0]), new Integer(lengthstr[1])};
        ArrayList<String> list1[] = new ArrayList[lengths[0]];
//        for(int i=0; i< lengths[0]; i++) {
//            list1[i] = new ArrayList<String>();
//        }

        for(int i=0; i< lengths[0]; i++) {
            list1[i] = new ArrayList<String>();
            String[] words = sc.nextLine().split(" ");
            for(int j=0; j< words.length; j++) {
                list1[i].add(words[j]);
            }
        }


        for(int i=0; i< lengths[1]; i++) {
            int index=-1,max=0;
            String[] words = sc.nextLine().split(" ");
            for(int j=0; j<lengths[0]; j++) {
                int num=0;
                for(int k=0; k<words.length ; k++) {
                    for(int p=0; p<list1[j].size(); p++) {
                        if(list1[j].get(p).toLowerCase().equals(words[k]))
                            num++;

                    }
                }
                if(num > max){
                    max = num;
                    index = j ;
                }

            }
            if(index == -1)
                System.out.println("");
            else {
                for( String str : list1[index]) {
                    System.out.print(str + " ");
                }
                System.out.println("");
            }
        }



    }
}
