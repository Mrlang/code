package DoDoDo.slide_window;

/**
 * Created by wangliang01 on 2020/7/2 using IDEA.
 *
 * 3. 无重复字符的最长子串
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
public class slide_window_3 {
    /*=================================================常规通用========================================================*/
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxlen = 0;
        int[] windowContainer = new int[128];

        while (right < s.length()) {
            char curRightChar = s.charAt(right);

            windowContainer[curRightChar]++;

            while (windowContainer[curRightChar] > 1) {
                char curLeftChar = s.charAt(left);
                left++;
                windowContainer[curLeftChar]--;
            }

            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }

    /*=================================================重写了一次,常规========================================================*/
    public int lengthOfLongestSubstring_0(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        int window[] = new int[128];

        while (right < s.length()) {
            char curRightChar = s.charAt(right);
            window[curRightChar]++;
            right++;

            //TODO 不能在这个地方提前计算length，因为后面left后边会++
            int curLength = right - left;

            //TODO window[curRightChar] > 0还是1，考虑清楚
            while (window[curRightChar] > 1) {
                /**
                 * TODO 内层循环必须做够三步，记得，不要丢了某一步了
                 * 1. 更新最值/方法要求的返回值 这一步看情况也可以放到while外面去更新
                 * 2. 更新window存储的数据
                 * 3. left右移
                 */
                char curLeftChar = s.charAt(left);
                window[curLeftChar]--;
                //TODO 注意left是++还是--
                left++;
            }

            //TODO 注意maxLength的更新放在while循环的哪个位置,还有right-left的计算
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }













}
