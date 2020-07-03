package leetCode.slide_window;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangliang01 on 2020/7/2 using IDEA.
 */
public class window_76 {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) {
            return "";
        }
        List<Character> list = new ArrayList();
        for (int i=0; i< t.length(); i++) {
            list.add(t.charAt(i));
        }
        Queue<Integer> queue = new ArrayDeque();
        int left=0;
        int right=0;
        int minLen = 0;
        int minLeft=0;
        int minRight=0;
        while(right <= s.length()) {

            if(list.contains(s.charAt(right))) {
                list.remove(new Character(s.charAt(right)));
                queue.add(right);
            }

            if(list.isEmpty()) {
                int curLen = right - left + 1;
                if( curLen < minLen || minLen == 0) {
                    minLeft = left;
                    minRight = right;
                    minLen = curLen;
                }
                left = queue.poll();
                list.add(s.charAt(left));
                left = queue.peek();
            }
            right++;
        }

        return minLen == 0 ? "" : s.substring(minLeft, minRight+1);
    }

    @Test
    public void test(){
        String a = "ADOBECODEBANC";
        String b = "ABC";
        minWindow(a,b);
    }

    @Test
    public void test1(){
        char a = 'a';
        System.out.println(a-0);
        System.out.println(a);
        System.out.println('A'-0);
        System.out.println('a' - 'A');
        System.out.println('o' - 'O');

    }

}
