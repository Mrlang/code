package Algorithm.niuKe.ExamQuNa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/1 using IDEA.
 */
public class Main {
    static ArrayList<String> pre = null, mid = null;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        String[] arr1 = sc.nextLine().split(" ");
        pre = change(arr1);

        String[] arr2 = sc.nextLine().split(" ");
        mid = change(arr2);

        a();
    }

    public static void a(){
        ArrayDeque<String> que = new ArrayDeque<>();
        que.add(pre.get(0));
        int num = 1;
        while(!que.isEmpty()){
            if(num!=0) {
                for(int i=0; i<num; i++) {
                    int num2 = 0;
                    System.out.println(que.removeFirst());
                    String left = getLeft();
                    if(left!=null){
                        que.add(left);
                        num2++;
                    }

                    String right = getRight();
                    if(right!=null) {
                        que.add(right);
                        num2++;
                    }
                }
            }

        }
    }

    public static String getLeft(){
        return null;
    }

    public static String getRight(){
        return null;
    }


    public static ArrayList<String> change(String[] arr){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        arr = null;
        return list;
    }
}
