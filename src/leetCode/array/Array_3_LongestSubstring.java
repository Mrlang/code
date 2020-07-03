package leetCode.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang01 on 2019/9/29 using IDEA.
 * 无重复字符的最长子串.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */






public class Array_3_LongestSubstring {

    //经典滑动窗口做法
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0, maxlen=0;
        int[] windowContainer = new int[128];

        while(right < s.length()) {
            char curRightChar = s.charAt(right);
            windowContainer[curRightChar]++;

            while(windowContainer[curRightChar] > 1) {
                char curLeftChar = s.charAt(left);
                left++;
                windowContainer[curLeftChar]--;
            }

            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }

    public int lengthOfLongestSubstring_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int i=0, j=0; j<s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(j)) + 1;
                // TODO: map里面可能有跟s.charAt(j)字符相同的 ,但不在当前子串范围内的.因为每一次更好i值,map里前面的数据都没清除
                // i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j-i+1);
        }
        return maxLength;
    }

    @Test
    public void test(){
        String a = "pwwkew";
        lengthOfLongestSubstring(a);
    }
}
