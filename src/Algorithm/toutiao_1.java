package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/8/22 using IDEA.

 P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 如下图：实心点为满足条件的点的集合。
 */
public class toutiao_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] points = new int[length][2];
        for(int i=0; i< length; i++){
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<length; i++) {
            boolean isMax = true;
            for(int j=0; j<length; j++) {
                if(j == i)
                    continue;
                if(points[j][0] > points[i][0] && points[j][1] > points[i][1]){
                    isMax = false;
                    break;
                }
            }
            if(isMax)
                list.add(points[i]);
        }

        for(int i=0; i<list.size()-1; i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
        System.out.print(list.get(list.size()-1)[0] + " " + list.get(list.size()-1)[1]);
    }
}
