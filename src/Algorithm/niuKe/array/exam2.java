package Algorithm.niuKe.array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/7 using IDEA.
 */
public class exam2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int length = scanner.nextInt();
        find(sum/length, length, sum);
    }

    public static void find(int end, int length, int sum){
        System.out.println("end is "+end+", length is "+length+", sum is "+sum);
        int total = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=end; i>=0; i--){
            list.add(i);
            total += i;

            if(list.size() == length){
                if(total > sum){
                    find(end-1, length, sum);
                    return;
                }
                if(total == sum){
                    prin(list);
                    return;
                }

            }else if(list.size() > length){
                if(total == sum){
                    prin(list);
                    return;
                }
                if(total > sum){
                    find(end-1, length, sum);
                    return;
                }
            }
        }
        System.out.println("No");
    }

    public static void prin(ArrayList<Integer> l){
        for(int i=l.size()-1; i>0 ; i--) {
            System.out.print(l.get(i)+" ");
        }
        System.out.print(l.get(0));
    }

}
