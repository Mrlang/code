package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang01 on 2019/9/29 using IDEA.
 * 无重复字符的最长子串.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */






public class Array_3_LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
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
}
