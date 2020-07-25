package DoDoDo.sword_point;

/**
 * 字符串的排列
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author wangliang01 on 2019/4/3 using IDEA.
 */
import org.junit.Test;

import java.util.*;

public class class_28 {
    @Test
    public void test(){
        List<String> list = myBetterMethod("abcd");
        System.out.println(list);

        List<String> list2 = Permutation("abcd");
        System.out.println(list);
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> resList = new ArrayList<>();
        if(str !=null || str.length() > 0){
            a(str.toCharArray(), 0, resList);
            Collections.sort(resList);
        }
        return resList;
    }

    public static void a(char[] chars, int beginIndex, List<String> resList) {
        if(beginIndex == chars.length - 1) {
            resList.add(new String(chars));
            return;
        }
        Set<Character> charSet = new HashSet<Character>();
        int i = beginIndex;
        for(int j=i; j<chars.length; j++) {
            if(j == i || !charSet.contains(chars[j])){
                charSet.add(chars[j]);
                exchange(chars, i, j);
                a(chars, i+1, resList);
                exchange(chars, i, j);
            }
        }
    }

    public static void exchange(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public List<String> myBetterMethod(String inputString) {
        Set<String> returnSet = new HashSet<>();

        if(inputString.length() == 1) {
            returnSet.add(inputString);
            return new ArrayList<>(returnSet);

        }

        char[] inputChars = inputString.toCharArray();
        for(int i=0; i<inputChars.length; i++) {
            exchange(inputChars, i, 0);
            Character beginChar = inputChars[0];
            String leftString = inputString.substring(1);
            List<String> subString = myBetterMethod(leftString);
            for (String s : subString) {
                returnSet.add(beginChar.toString() + s);
            }
        }
        return new ArrayList<>(returnSet);
    }


}