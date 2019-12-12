package Algorithm.Offer;

/**
 * Created by wangliang01 on 2019/9/10 using IDEA.
 * 翻转单词顺序VS左旋字符串
 * 题目1：输入"I am s student."，则输出"student. a am I"    https://blog.csdn.net/snow_7/article/details/52212396
 * 题目2: 输入"abcdefg"和数字2,返回"cdefgab"
 *
 * 思路： 需要先实现一个翻转整个字符串的方法,
 * 题目1思路: 将大串翻转后,需要确定里面每一个单词的位置。需要两个指针,一个指向单词开头,一个指针向后移动(遇到' '或者移到数组最后,说明是这个单子的结尾地方)
 * 题目2思路: 把字符串看成两部分，要左移的n位分为一部分，剩下的分为一部分。分别翻转之后,整个字符串再翻转一次,会奇妙的发现竟然完成了左旋。
 */
public class class_42 {
    public static void main(String args[]){
        System.out.println(LeftRotateString("12345678", 4));
    }

    // 投机
    public static String LeftRotateString(String str,int n) {
        String res = "";
        if(str == null || str .equals("") ){
            return res;
        }
        String temp1 = str.substring(0, n);
        String temp2 = str.substring(n, str.length());
        res = (temp2 + temp1);
        return res;
    }

}
