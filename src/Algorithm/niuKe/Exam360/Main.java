package Algorithm.niuKe.Exam360;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/25 using IDEA.
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] twoNum = sc.nextLine().split(" ");
        String[] mainTask = sc.nextLine().split(" ");
        int[] tempTask = new int[new Integer(twoNum[1])];
        for(int i=0; i<new Integer(twoNum[1]); i++){
            tempTask[i] = new Integer(sc.nextLine());
        }
        print(mainTask, tempTask);
    }

    public static void print(String[] mainTask, int[] tempTask){
        int j=0,i=0,time=new Integer(mainTask[0]);
        while(i<mainTask.length){
            while(j<tempTask.length && tempTask[j] < time){
                if(tempTask[j] <= new Integer(mainTask[i-1]))
                    System.out.println(new Integer(mainTask[i-1]) + 1);
                else
                    System.out.println(tempTask[j]);
                j++;
            }

            while(i+1<mainTask.length && new Integer(mainTask[i+1]) == new Integer(mainTask[i])+1)  {
                i++;
            }

            if(i==mainTask.length-1) {
                time = new Integer(mainTask[mainTask.length-1]) + 1;
                i++;
                break;
            }

            time = new Integer(mainTask[++i]);

        }


        for(int n=j; n<tempTask.length ; n++) {
            System.out.println(time);
        }
    }
}
