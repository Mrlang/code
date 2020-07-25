package DoDoDo.array;

/**
 * Created by wangliang01 on 2019/9/30 using IDEA.
 * 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 */
public class Array_5_Palindromic_Substring {
    public String longestPalindrome_1(String s) {
        int length = s.length();
        String returnString = "";
        boolean[][] history = new boolean[length][length];
        for(int i=length-1; i>=0; i--) {
            for(int j=length-1; j>=i; j--) {
                //TODO j-i+1是当前子串的长度
                history[i][j] = (j-i+1<3 || history[i+1][j-1]) && s.charAt(i)==s.charAt(j);
                if(history[i][j] && j-i+1 > returnString.length()) {
                    //TODO subString方法是左闭右开
                    returnString = s.substring(i, j+1);
                }
            }
        }
        return returnString;
    }

    public String longestPalindrome_2(String s) {
        int length = s.length();
        String returnString = "";
        boolean[] history = new boolean[length];
        for(int i=length-1; i>=0; i--) {
            for(int j=length-1; j>=i; j--) {
                history[j] = (j-i+1<3 || history[j-1]) && s.charAt(i)==s.charAt(j);
                if(history[j] && j-i+1 > returnString.length()) {
                    returnString = s.substring(i, j+1);
                }
            }
        }
        return returnString;
    }

}
