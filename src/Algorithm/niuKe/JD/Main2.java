package Algorithm.niuKe.JD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/7 using IDEA.
 */
public class Main2 {
    public static void main(String srgs[]){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        double p[] = new double[length];
        for(int i=0; i<length; i++){
            p[i] = (double)sc.nextInt()/100;
        }
        double[][] dp = new double[length+1][length+1];
        dp[0][0] = 1;
        for(int i=1; i<length+1; i++){
            dp[i][0] = dp[i-1][0] * (1-p[i-1]);
            for(int j=1; j<=i; j++)
                dp[i][j] = dp[i-1][j-1] * p[i-1] + dp[i-1][j]*(1-p[i-1]);
        }

        double res = 0;
        for(double i=Math.ceil(length*0.6); i<=length; i++){
            res += dp[length][(int)i];
        }
        System.out.printf("%.5f",res);
    }
}