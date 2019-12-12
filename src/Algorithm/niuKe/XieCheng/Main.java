package Algorithm.niuKe.XieCheng;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/11 using IDEA.
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getRes(n));
    }

    public static int getRes(int n){
        if(n==3 || n==4)
            return n-1;
        int sum=0,rest=0,avg=0,mod=0;
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]  =1;
        }
        for(int i=2,length=0; i<=n; i++,length++){
            sum += i;
            if(sum > n)
            {
                rest = n-(sum-i);
                if(rest < length){
                    avg=1;
                    mod=0;
                }else{
                    avg = rest/length;
                    mod = rest % length;
                }
                for(int j=i-1; j>=i-rest; j--){
                    arr[j] += avg;
                }
                arr[i-1] += mod;
                break;
            }

            arr[i] = i;
        }

        for(int i=2; i<=n; i++) {
            rest *= arr[i];
        }

        return rest;

    }
}

/*
    携程技术类2018届春招 后台开发工程师 在线考试
        编程题 | 20分 1/1
        股票交易
        时间限制：C/C++语言 1000MS；其他语言 3000MS
        内存限制：C/C++语言 10240KB；其他语言 534528KB
        题目描述：
        一个一维数组，记录n天中每天的携程股价。
        股市交易规则如下：
        a）一天只能有买进或者卖出一种操作，也可以不做任何操作，卖出时价格减买入时价格即为收益
        b）每次卖出操作后有冻结期，k天之后才能进行下一次买进操作（k>=1）
        c）买进之后必须卖出才能再次买进
        设计一个算法，找到交易收益最大化的买进卖出策略，返回最后的最大收益值

        输入
        一维正整数数组，表示每天股价
        正整数k，表示冷冻期

        输出
        返回最大收益

        样例输入
        int[] sotckPrice = {1,2,3,5,2,6,3,7};
        int k = 2;
        输入为
        8（表示数组长度）
        1（开始依次输入数组元素）
        2
        3
        5
        2
        6
        3
        7
        2（输入k）
        样例输出
        8
        (1买进，5卖出，3买进，7卖出，收益最大为8)

        Hint
        没有头绪的话，先从k=1开始思考吧
*/

/*
        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能*/
/*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
/*

    static int maxProfit(int[] stockPrices, int k) {



    }
    /******************************结束写代码******************************/

/*
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _stockPrices_size = 0;
        _stockPrices_size = Integer.parseInt(in.nextLine().trim());
        int[] _stockPrices = new int[_stockPrices_size];
        int _stockPrices_item;
        for(int _stockPrices_i = 0; _stockPrices_i < _stockPrices_size; _stockPrices_i++) {
            _stockPrices_item = Integer.parseInt(in.nextLine().trim());
            _stockPrices[_stockPrices_i] = _stockPrices_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = maxProfit(_stockPrices, _k);
        System.out.println(String.valueOf(res));

    }
}
*/