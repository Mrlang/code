package Algorithm.Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang01 on 2019/7/17 using IDEA.
 *
 * 因子中只包含2\3\5的数成为丑数。求按从小到大顺序的第1500个丑数(1是第一个丑数)
 * 首先要会写子函数-如果判断一个数是不是丑数.
 */
public class class_34 {

    @Test
    public void test(){
        int k = 6;
        System.out.println(resolve_1_right(k));
        System.out.println(resolve2(k));
    }

    //错误的写法
    public int resolve_1_error(int k) {
        int count = 0;
        int num = 1;
        while(count < k) {
            if(isUgly(num)) {
                count++;
            }
            num++;
        }

        return num;
    }

    public int resolve_1_right(int k) {
        int count = 0;
        int num = 0;
        while(count < k) {
            num++;
            if(isUgly(num)) {
                count++;
            }
        }

        return num;
    }

    public int resolve_1_right111(int k) {
        int count = 0;
        int num = 1;
        while(count < k) {
            if(isUgly(num)) {
                count++;
            }

            if(count == k) {
                return num;
            }

            num++;
        }

        return num;
    }

    private boolean isUgly(int num) {
        while (num % 2 == 0){
            num = num / 2;
        }

        while (num % 3 == 0){
            num = num / 3;
        }

        while (num % 5 == 0){
            num = num / 5;
        }

        return num == 1 ? true : false;
    }

    private int resolve2(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while(list.size() < k) {
            int a = list.get(index2) * 2;
            int b = list.get(index3) * 3;
            int c = list.get(index5) * 5;
            int min = Math.min(a, Math.min(b,c));
            list.add(min);

            if(a == min) {
                index2++;
            }
            if(b == min) {
                index3++;
            }
            if(c == min) {
                index5++;
            }

        }

        return list.get(list.size() - 1);

    }

}
