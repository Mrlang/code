package leetCode.DP_dynamic_programming;

import java.util.*;

/**
 * Created by wangliang01 on 2020/6/21 using IDEA.
 * 01背包
 * https://www.nowcoder.com/questionTerminal/7e157ce9a8c249daa3ddafad322dbf1e
 */

public class Dp_niuKe_01package {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goodsNum = scanner.nextInt();
        int bagCapacity = scanner.nextInt();

        int[] goodsWeight = new int[goodsNum + 1];
        int[] goodsValue = new int[goodsNum + 1];
        goodsWeight[0] = 0;
        goodsValue[0] = 0;

        for(int i = 1; i<=goodsNum; i++) {
            goodsWeight[i] = scanner.nextInt();
        }

        for(int i = 1; i<=goodsNum; i++) {
            goodsValue[i] = scanner.nextInt();
        }

        int[][] dp_cache = new int[goodsNum + 1][bagCapacity + 1];
        for(int i=1; i<=goodsNum; i++) {
            for(int curBagWeight=1; curBagWeight<=bagCapacity ; curBagWeight++) {
                int curWeight = goodsWeight[i];
                int curValue = goodsValue[i];

                if(curBagWeight-curWeight < 0) {
                    dp_cache[i][curBagWeight] = dp_cache[i-1][curBagWeight];
                }else {
                    dp_cache[i][curBagWeight] = Math.max(dp_cache[i-1][curBagWeight-curWeight] + curValue, dp_cache[i-1][curBagWeight]);
                }
            }
        }

        System.out.println(dp_cache[goodsNum][bagCapacity]);
    }
}