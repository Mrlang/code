package Algorithm.niuKe.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

/**
 * Created by Mr_liang on 2016/11/16.
 */
public class SumIsGiven {
    @Test
    public void test() {
//        ArrayList<Integer> l = FindNumbersWithSum(new int[]{1,2,4,7,11,16},10);
//        if(!l.isEmpty())
//        System.out.println(l.get(0) + "---" + l.get(1));
        consTest c = new consTest();
        System.out.println(c.time);
    }

    // a+b=s, 求a*b  a=b时a*b最大, a越小b越大时a*b越小
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeSet<Integer> tree = new TreeSet<>();
        //其他几对数字也遍历了取出来,存在tree中,之后没用到,多余操作。而且排序好的数组,还用tree,算法没能充分利用现有条件
        for(int i=0; i<array.length; i++) {
            if(list.contains((Integer)(sum-array[i]))) {
                tree.add((Integer)array[i]);
                tree.add((Integer)(sum-array[i]));
            }
            else
                list.add(array[i]);
        }
        list.clear();
        //还有可能一对也没有,tree中是空
        if( !tree.isEmpty()) {
            Integer a = tree.first();
            list.add(a);
            list.add(sum - a);
            return list;
        }
        return list;
    }

    public ArrayList<Integer> beautiful(int [] array, int sum) {
        //排序好的,和是一定的,相距越远的两个数字积越小   左右夹逼开始找,和为S的第一对就是所有对中相距最远的,积最小,其他几对根本不用再找
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int x = 0, y = array.length-1;
//        次数不确定的循环,就用while
        while (x < y) {
            if(array[x]+array[y]==sum){
                list.add(array[x]);
                list.add(array[y]);
                return list;
            }else if(array[x]+array[y]>sum){
                y--;
            }else {
                x++;
            }
        }
        return list;
    }

}



class consTest{
    public long time = this.setTime();
    public consTest() {
        System.out.println(this.time);
        this.time = 666;
        this.sayHello();
    }

    public void sayHello() {
        System.out.println("hello world");
    }

    public long setTime() {
        return new Date().getTime();
    }
}
