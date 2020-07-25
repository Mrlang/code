package DoDoDo.slide_window;

import org.junit.Test;

/**
 * Created by wangliang01 on 2020/7/22 using IDEA.
 *
 * 340. 至多包含 K 个不同字符的最长子串
 *
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 *
 * 示例 1:
 *
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slide_window_340 {

    /*=================================================常规通用========================================================*/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[]  windowArr = new int[127];
        int left=0, right=0, windowNum = 0, maxLen = 0, curLen=0;

        while(right < s.length()) {
            char curRightChar = s.charAt(right);
            if(windowArr[curRightChar] == 0) {
                windowNum++;
            }
            windowArr[curRightChar]++;
            curLen++;
            right++;

            while(windowNum > k) {
                char curLeftChar = s.charAt(left);
                windowArr[curLeftChar]--;
                curLen--;
                if(windowArr[curLeftChar] == 0) {
                    windowNum--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
