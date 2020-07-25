package DoDoDo.slide_window;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangliang01 on 2020/7/22 using IDEA.
 *
 * 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slide_window_438 {
    private Map<Character, Integer> targetMap = new HashMap<>();
    private Map<Character, Integer> windowMap = new HashMap<>();

    /*=================================================常规通用,基于567为基础========================================================*/
    public List<Integer> findAnagrams(String s, String p) {
        Set<Integer> returnList = new HashSet<>();
        if(s == null || s.length() == 0 || p==null || p.length()==0) {
            return new ArrayList<>(returnList);
        }
        int left=0, right=0;

        for (int i = 0; i < p.length(); i++) {
            //TODO 不要把window的前部分初始化放到这里，直接按模板，全部放到下文的外层while里
            Character c1 = p.charAt(i);
            targetMap.put(c1, targetMap.getOrDefault(c1, 0) + 1);
        }

        while(right < s.length() ) {
                Character curRightChar = s.charAt(right);
                windowMap.put(curRightChar, windowMap.getOrDefault(curRightChar, 0) + 1);
                right++;
                while(windowMap.getOrDefault(curRightChar, 0) > targetMap.getOrDefault(curRightChar, 0)) {
                    Character curLeftChar = s.charAt(left);
                    windowMap.put(curLeftChar, windowMap.getOrDefault(curLeftChar, 0) - 1);
                    //TODO 已经从window中剔除的字符，要从map中删除，否则会影响后面的windowMap.size() == targetMap.size()判断
                    if(windowMap.get(curLeftChar) == 0) {
                        windowMap.remove(curLeftChar);
                    }

                    left++;
                }

                if(windowSatisfy()) {
                    returnList.add(left);
                }
        }

        return new ArrayList<>(returnList);
    }

    private boolean windowSatisfy() {
        if(windowMap.size() != targetMap.size()) {
            return false;
        }

        Set<Character> keySet = targetMap.keySet();
        for (Character key : keySet) {
            if(!windowMap.getOrDefault(key, 0).equals(targetMap.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }

    /*=================================================常规通用,别人提供的数组作为window而不是map========================================================*/
    public List<Integer> findAnagrams_0(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
        for(char ch : p.toCharArray()){
            needs[ch - 'a'] ++;
        }
        while(right < s.length()){
            char chr = s.charAt(right);
            if(needs[chr - 'a'] > 0){
                window[chr - 'a'] ++;
                if(window[chr - 'a'] <= needs[chr - 'a']){
                    total --;
                }
            }
            while(total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0){
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']){
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }

    /*=================================================junit========================================================*/
    @Test
    public void test(){
        System.out.println(findAnagrams("ababababab", "aab"));
    }
}

