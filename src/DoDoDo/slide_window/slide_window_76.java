package DoDoDo.slide_window;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangliang01 on 2020/7/2 using IDEA.
 *
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slide_window_76 {
    /*=================================================常规通用========================================================*/
    Map<Character, Integer> targetMap = new HashMap<>();
    Map<Character, Integer> windowMap = new HashMap<>();
    public String minWindow(String s, String t) {
        int left=0, right = 0;
        int returnLeft = 0, returnRight = 0;
        //TODO MIN还是MAX  要考虑好
        int minLength = Integer.MAX_VALUE;

        for(int i=0; i<t.length(); i++) {
            Character c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        while(right < s.length()) {
            Character curChar = s.charAt(right);
            if(targetMap.containsKey(curChar)) {
                windowMap.put(curChar, windowMap.getOrDefault(curChar, 0) + 1);
            }
            //TODO 这个地方++之后考虑好后面计算lenght是否还要+1
            right++;

            //TODO 其实不需要条件left<right,但是写冗余点没关系。windowSatisfy()见438
            while(left < right && windowSatisfy()) {
                /**
                 * TODO 内层循环必须做够三步，记得，不要丢了某一步了
                 * 1. 更新最值/方法要求的返回值 这一步看情况也可以放到while外面去更新
                 * 2. 更新window存储的数据
                 * 3. left右移
                 */
                int curLenght = right - left;
                if(curLenght < minLength) {
                    minLength = curLenght;
                    returnLeft = left;
                    returnRight = right-1;
                }

                Character curLeftChar = s.charAt(left);
                if(targetMap.containsKey(curLeftChar)) {
                    windowMap.put(curLeftChar, windowMap.getOrDefault(curLeftChar, 0) - 1);
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE  ?  "" : s.substring(returnLeft, returnRight+1);
    }

    /**
     * TODO 判断当前window是否为满足题目要求的情况之一，可以单独拎一个方法出来进行判断，千万别偷懒想直接在主方法里就开写。
     *      把逻辑写完整了，即使读写点，条件冗余点都行，就是别漏写了就麻烦了
     */
    public boolean windowSatisfy() {
        Set<Character> keySet = targetMap.keySet();
        for (Character key : keySet) {
            if(windowMap.getOrDefault(key, 0) < targetMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    /*=================================================自己想的========================================================*/
    // todo 这个代码是自己想的，比较便利，但不能完全成功
    public String minWindow_1(String s, String t) {
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

    /*=================================================junit========================================================*/
    @Test
    public void test(){
        String a = "ADOBECODEBANC";
        String b = "ABC";
        System.out.println(minWindow(a,b));
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
