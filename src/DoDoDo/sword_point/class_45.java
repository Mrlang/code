package DoDoDo.sword_point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_liang on 2017/8/13 using IDEA.
 */

//约瑟夫环，面试题45：圆圈中最后剩下的数字(约瑟夫环问题)
//0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。求出这个圈圈里剩下的最后一个数字
public class class_45 {
    public static void main(String[] segs){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<6; i++) {
            list.add(i);
        }
        int m = 2;
        int res = getLastNum(list, m);
        System.out.println(res);
    }

    public static int getLastNum(List<Integer> list, int m){
        int i=0;
        while(list.size() > 1) {
            i += m;
            i = i % list.size();
            list.remove(i);
        }
        return list.get(0);
    }


}
