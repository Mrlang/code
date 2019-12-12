package Algorithm.niuKe.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mr_liang on 2016/11/13.
 *
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class ListAllPermutations {
    public static void main(String args[]) {
        ArrayList<String> l = Permutation("aba");
        for (String s:l) {
            System.out.println(s);
        }

    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() == 0)
            return list;
        if(str.length() == 1) {
            list.add(str);
            return list;
        }
        String[] arr = str.split("");
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            String afterStr= "";
//            for (int m=0; m<i; m++)
//                afterStr += arr[m];
//            for (int m=i+1; m<arr.length; m++)
//                afterStr += arr[m];
            for(int m=0; m<arr.length; m++) {
                if(m != i)
                    afterStr += arr[m];
            }
            ArrayList<String> pre = Permutation(afterStr);
            int size = pre.size();
            for(int j=0; j<size; j++) {
                String n_str = arr[i] + pre.get(j);
                if(!list.contains(n_str))
                    list.add(n_str);
            }
        }
        return list;

    }
}
