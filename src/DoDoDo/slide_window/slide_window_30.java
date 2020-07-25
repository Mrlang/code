package DoDoDo.slide_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangliang01 on 2020/7/22 using IDEA.
 *
 * 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO
 *  两个思路
 *  思路1. 利用所有单词相等的特性，给了n个单词，那么符合题目所求的字符串的长度m 一定等于 m =  n*word.length(), 遍历所有长度为m的字符串，看那个符合题目要求
 *  思路2. 之前的常规题目，left、right每次都是前进一步index++，这次将一个单词的长度word.length() 作为最小前进单位。
 *  讲解: https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-powcai/
 */
public class slide_window_30 {
    Map<String, Integer> windowMap = new HashMap<>();
    Map<String, Integer> targetMap = new HashMap<>();

    /*=================================================看别人的1========================================================*/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> returnList = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return returnList;
        }

        int word_length = words[0].length();
        int words_length = words.length * word_length;


        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word,0) + 1);
        }

        for(int i=0; i+words_length <= s.length(); i++) {
            //TODO 这个地方记得要清空window窗口数据
            windowMap = new HashMap<>();
            for(int j=0; j<words.length; j++) {
                int curBegin = i+j*word_length;
                String curWord = s.substring(curBegin, curBegin + word_length);
                windowMap.put(curWord, windowMap.getOrDefault(curWord,0) + 1);
            }

            if(windowSatisfy()) {
                returnList.add(i);
            }
        }

        return returnList;
    }

    private boolean windowSatisfy() {
        return windowMap.equals(targetMap);
    }

    /*=================================================看别人的2========================================================*/
    public List<Integer> findSubstring_2(String s, String[] words) {
        List<Integer> returnList = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return returnList;
        }

        int word_length = words[0].length();
        int words_length = words.length * word_length;


        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word,0) + 1);
        }

        int left=0, right=0, step = word_length;
        while(right < s.length()) {

            while() {
                left += step;
            }

            returnList.add(left);
        }

        return returnList;
    }

}
