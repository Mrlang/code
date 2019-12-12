package Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/9/2 using IDEA.
 */
public class lianjia_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int pack = sc.nextInt();
        List<good> goods = new ArrayList<>();
        int finds[] = new int[num1];
        int findsw[] = new int[num1];
        int findss[] = new int[num1];
        int total = 0;
        for(int i=0; i<num1; i++) {
            int num = sc.nextInt();
            int tiji = sc.nextInt();
            int jiazhi = sc.nextInt();
            for(int j=0; j<num; j++) {
                good good = new good(tiji, jiazhi);
                goods.add(good);
            }
        }
//        int[] jiazhi = new int[total];
//        int[] tiji = new int[total];
//        for(int i=0; i<finds.length; i++) {
//            for(int j=0; j<finds[i]; j++) {

//                jiazhi[index] = findss[i];
//                tiji[index] = findsw[i];
//                index++;
//                goods.add(new good(findsw[i], findss[i]));
//            }

//        }

//        System.out.println(knapsack( jiazhi, tiji, 10));
    System.out.print(handle(goods, pack));
    }

    public static int knapsack(int val[], int wt[], int W) {
        //Get the total number of items.
        //Could be wt.length or val.length. Doesn't matter
        int N = wt.length;

        //Create a matrix.
        //Items are in rows and weight at in columns +1 on each side
        int[][] V = new int[N + 1][W + 1];

        //What if the knapsack's capacity is 0 - Set
        //all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }

        //What if there are no items at home.
        //Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }

        for (int item=1;item<=N;item++){
            //Let's fill the values row by row
            for (int weight=1;weight<=W;weight++){
                //Is the current items weight less
                //than or equal to running weight
                if (wt[item-1]<=weight){
                    //Given a weight, check if the value of the current
                    //item + value of the item that we could afford
                    //with the remaining weight is greater than the value
                    //without the current item itself
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    //If the current item's weight is more than the
                    //running weight, just carry forward the value
                    //without the current item
                    V[item][weight]=V[item-1][weight];
                }
            }

        }

        //Printing the matrix
//        for (int[] rows : V) {
//            for (int col : rows) {
//                System.out.format("%5d", col);
//            }
//            System.out.println();
//        }
        return V[N][W];
    }

    public static int handle(List<good> goods, int pake){
        Collections.sort(goods);
        int jiazhi = 0;
        int currentIndex = 0;
        while (currentIndex < goods.size()){
            good good = goods.get(currentIndex);
            if(pake >= good.tiji){
                pake = pake - good.tiji;
                jiazhi += good.jiazhi;
                currentIndex++;
            }else {
                currentIndex++;
            }

        }
        return jiazhi;
    }
}

class good implements Comparable<good>{
    int tiji;
    int jiazhi;

    public good(int tiji, int jiazhi) {
        this.tiji = tiji;
        this.jiazhi = jiazhi;
    }

    @Override
    public int compareTo(good o) {
        double v = this.jiazhi * 1.0 / this.tiji ;
        double v1 = o.jiazhi * 1.0 / o.tiji;
        if(v > v1)
            return -1;
        if(v < v1)
            return  1;
        return 0;
    }


}
