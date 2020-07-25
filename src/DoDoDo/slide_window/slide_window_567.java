package DoDoDo.slide_window;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangliang01 on 2020/7/22 using IDEA.
 *
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slide_window_567 {
    private Map<Character, Integer> targetMap = new HashMap<>();
    private Map<Character, Integer> windowMap = new HashMap<>();

    /*=================================================常规通用,引入438========================================================*/
    public boolean checkInclusion(String s1, String s2) {
        for(int i=0; i<s1.length(); i++) {
            char curChar = s1.charAt(i);
            targetMap.put(curChar,  targetMap.getOrDefault(curChar,0) + 1);
        }

        int left = 0,right = 0;
        while(right < s2.length()) {
            char curRightChar = s2.charAt(right);
            windowMap.put(curRightChar, windowMap.getOrDefault(curRightChar, 0)+1) ;
            right++;

            while(windowMap.getOrDefault(curRightChar, 0) > targetMap.getOrDefault(curRightChar, 0)) {
                char curLeftChar = s2.charAt(left);
                windowMap.put(curLeftChar, windowMap.getOrDefault(curLeftChar,0) - 1);

                //TODO 这个有点关键
                if(windowMap.getOrDefault(curLeftChar, 0) == 0) {
                    windowMap.remove(curLeftChar);
                }
                left++;
            }

            if(windowSatify()) {
                return true;
            }
        }

        return false;
    }

    private boolean windowSatify() {
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
    public boolean checkInclusion_1(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 == 0) return true;
        if (len2 < len1) return false;

        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray();

        // 对s1中的字符计数，没出现过的字符为-1
        int[] count = new int[26];
        Arrays.fill(count, -1);
        for (char c : ss1) {
            if (count[c - 'a'] == -1)
                count[c - 'a'] = 1;
            else
                count[c - 'a'] ++;
        }

        // 使用滑窗进行遍历
        int start = 0, end = 0;
        while (start <= len2 - len1) {      // while 1
            while (end < start + len1) {    // while 2

                // 如果对应位置为0，则移动start寻找使其不为0的点作为新起点
                if (count[ss2[end] - 'a'] == 0) {
                    while (count[ss2[end] - 'a'] == 0)
                        count[ss2[start ++] - 'a'] ++;
                    break;
                }

                // 如果对应位置为-1，则移动start至当前end的下一个位置，并令end=start
                if (count[ss2[end] - 'a'] == -1) {
                    while (start < end)
                        count[ss2[start ++] - 'a'] ++;
                    start ++;
                    end = start;
                    break;
                }

                // 没有以上两种情况，则对应位置计数-1
                count[ss2[end ++] - 'a'] --;
            }

            // 如果end==start+len1，则说明while2遍历完成，未被break，因此返回true
            if (end == start + len1)
                return true;
        }
        return false;
    }

    /*=================================================junit========================================================*/
    @Test
    public void test(){
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
