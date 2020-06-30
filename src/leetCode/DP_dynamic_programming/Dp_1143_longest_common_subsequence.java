package leetCode.DP_dynamic_programming;

/**
 * Created by wangliang01 on 2020/6/30 using IDEA.
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp_1143_longest_common_subsequence {

    /**
     * TODO: 这个初始化的cache数组，长度没有冗余+1,所有需要对所有初始化情况进行赋值
     */
    public int longestCommonSubsequence_0(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int dp_cache[][] = new int[text1.length()][text2.length()];

        dp_cache[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for(int i=1; i<text1.length(); i++) {
            dp_cache[i][0] = chars1[i] == chars2[0] ? 1 : dp_cache[i-1][0];
        }

        for(int j=1; j<text2.length(); j++) {
            dp_cache[0][j] = chars1[0] == chars2[j] ? 1 : dp_cache[0][j-1]       ;
        }

        for(int i=1; i<text1.length(); i++) {
            for(int j=1; j<text2.length(); j++) {
                if(chars1[i] == chars2[j]) {
                    dp_cache[i][j] = dp_cache[i-1][j-1] + 1;
                }else{
                    dp_cache[i][j] = Math.max(dp_cache[i-1][j], dp_cache[i][j-1]);
                }
            }
        }

        return dp_cache[text1.length() -1 ][text2.length() -1 ];
    }

    /**
     * TODO: 这个初始化的cache数组，长度进行了冗余+1, 考虑的情况就比较简单
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int cache[][] = new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1] + 1;
                }else{
                    cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
                }
            }
        }

        return cache[m][n];
    }
}
