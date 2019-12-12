package Algorithm.niuKe.numberList;

/**
 * Created by Mr_liang on 2016/11/13.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class FeiBoNaQi {

    public static void main(String args[]) {

    }

    // time:953ms size:629k
    public int Fibonacci_1(int n) {
        if(n<1) return 0;
        if(n==1 || n==2) return 1;
        return  Fibonacci_1(n-1) + Fibonacci_1(n-2);
    }

    //time:31 size:629K
    public int FiFibonacci(int n) {
        if(n<1) return 0;
        if(n==1 || n==2) return 1;
        int a = 1,b = 1,sum=0;
        for(int i=2; i<n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
