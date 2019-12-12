package Algorithm.niuKe.numberList;

import java.util.*;

/**
 * Created by Mr_liang on 2016/11/11.
 *
 [编程题]微信红包
 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 若没有金额超过总数的一半，返回0。
 测试样例：
 [1,2,3,2,2],5
 返回：2
 */
public class OverHalfNum {
    public static void main(String args[]) {
        getValue_3(new int[]{1,2,3,2,2}, 5);
    }

    //用到了排序,时间复杂度有点高O(nlgn)
    public static int getValue_1(int[] gifts, int n) {
        int count = 1;
        Arrays.sort(gifts);
        for(int i=1; i<n-1; i++) {
            if(gifts[i] == gifts[n/2])
                count++;
        }
        return count > n/2 ? gifts[n/2] : 0;
    }

    //最低复杂度:n    《编程之美》:寻找水王
    public static int getValue_2(int[] gifts, int n) {
        int count = 0,temp = -11111;
        for(int i=1; i<n; i++) {
            if(count == 0) {
                temp = gifts[i];
                count = 1;
            }
            else
                if( temp == gifts[i] )
                    count++;
                else
                    count--;
        }

        int num = 0;
        for(int i=0; i<n; i++) {
            if(gifts[i] == temp)
                num++;
        }

        return (num>n/2) ? temp : 0;
    }

    public static int getValue_3(int[] gifts, int n) {
        Hashtable<Integer,Integer> counts = new Hashtable<Integer, Integer>();
        int count = 0;
        for(int i=0; i<n; i++) {
            if( !counts.containsKey((Integer)gifts[i]) )
                counts.put((Integer)gifts[i], 1);
            else{
                count = counts.get((Integer)gifts[i]);
                counts.put((Integer)gifts[i], count+1);
            }
        }
        Set<Map.Entry<Integer,Integer>> s = counts.entrySet();
        for(Map.Entry<Integer,Integer> m : s) {
            if((int)m.getValue() > n/2)
                return m.getKey();
        }

        return 0;
    }
}
