package Algorithm.niuKe.array;

import org.junit.Test;

/**
 * Created by Mr_liang on 2016/11/16.
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * emphasis:查找
 * 思路：首先我们选择从左下角开始搜寻，(为什么不从左上角开始搜寻，左上角向右和向下都是递增，那么对于一个点，对于向右和向下会产生一个岔路；如果我们选择从左下脚开始搜寻的话，如果大于就向右，如果小于就向下)。
 * 个人感觉有点像减治法的意思,target比这个左下角大的,就抛弃第一竖列,从剩余矩阵里查找,因为第一竖列里的数肯定是小于左下角的;target比这个左下角小的话,就抛弃最后一横行,从剩余的矩阵里查找,因为最后一横行的数肯定是大于左下角的。
 */

public class TwoDimensionalArray {
    @Test
    public void test(){
        int target = 7;
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean b = find(target, array);
    }

    public boolean find(int target, int[][] array) {
        int x = array.length-1, y = 0;
        while(x>=0 && y<=array[0].length-1) {
            if(target > array[x][y] )
                y++;
            else if(target < array[x][y])
                x--;
            else
                return true;
        }
        return false;
    }
}
