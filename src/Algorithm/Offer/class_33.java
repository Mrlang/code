package Algorithm.Offer;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangliang01 on 2019/7/12 using IDEA.
 * 把数组排成最小的数
 * {3, 32, 321}  ->  321323
 */
public class class_33 {

    @Test
    public void test(){
        int[] arr = new int[]{3, 32, 321};
        sort(arr);
    }

    public void sort(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1 + "" + o2;
                String b = o2 + "" + o1;
                return a.compareTo(b);
            }
        });

        StringBuffer sum = new StringBuffer("");
        for (Integer integer : list) {
            sum.append(integer);
        }
        System.out.println(sum);
    }

}
