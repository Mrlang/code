package DoDoDo.hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang01 on 2020/6/19 using IDEA.
 *
 * 给出包含重复字符的char数组,进行全排列:
 *
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackTrack_08_permutations_2 {
    List<String> resList = new ArrayList<>();
    String input;
    public String[] permutation(String S) {
        input = S;
        backTrack("", 0);

        String[] resStr = new String[resList.size()];
        for(int i=0; i<resList.size(); i++) {
            resStr[i] = resList.get(i);
        }
        return resStr;
    }

    private void backTrack(String curPath, int curIndex) {
        if(curPath.length() == input.length() && !resList.contains(curPath)) {
            resList.add(curPath);
            return;
        }

        for(int i=curIndex; i<input.length(); i++) {
            String curChar = input.substring(i, i+1);
            swapInput(i, curIndex);
            backTrack(curPath + curChar, curIndex+1);
            swapInput(i, curIndex);
        }
    }

    private void swapInput(int x, int y) {
        char[] charArray = input.toCharArray();
        char temp = charArray[x];
        charArray[x] = charArray[y];
        charArray[y] = temp;
        input = new String(charArray);
    }

    @Test
    public void test(){
        String[] res = permutation("qqe");
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
