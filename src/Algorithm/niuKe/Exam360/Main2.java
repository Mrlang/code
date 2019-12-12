package Algorithm.niuKe.Exam360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/3/25 using IDEA.
 */
public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for(int begin=0; begin< str.length()-1; begin++){
            for(int end=begin+1; end< str.length(); end+=2){
//                String tempStr = str.copyValueOf(str.toCharArray(), begin, end-begin+1);
                char[] tempchar = new char[end-begin+1];
                System.arraycopy(str.toCharArray(), begin, tempchar, 0, end-begin+1);
                if(checkDouble(tempchar))
                    count++;
            }
        }
        System.out.println(count);
    }

    public static boolean checkDouble(char[] chars){
        if(chars.length%2!=0)
            return false;
        else{
            Arrays.sort(chars);
            for(int i=0; i< chars.length; i+=2) {
                if(chars[i]!=chars[i+1])
                    return false;
            }
//            HashMap<Character, Integer> map = new HashMap<>();
//            for(int i=0; i< chars.length; i++) {
//                if(map.containsKey(chars[i])){
//                    int a = map.get(chars[i]);
//                    map.put(chars[i], a++);
//                }
//                else {
//                    map.put(chars[i], 1);
//                }
//            }
//            for( Integer in : map.values()) {
//                if(in%2!=0)
//                    return false;
//            }
        }
        return true;
    }

    public static boolean checkDouble( String str ,int begin, int end){
        if((end-begin+1)%2!=0)
            return false;
        else{
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i< str.length(); i++) {
                if(map.containsKey(str.charAt(i))){
                    int a = map.get(str.charAt(i));
                    map.put(str.charAt(i), a++);
                }
                else {
                    map.put(str.charAt(i), 1);
                }
            }
            for( Integer in : map.values()) {
                if(in%2!=0)
                    return false;
            }
        }
        return true;
    }
}
