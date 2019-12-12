package leetCode.array;

/**
 * 344
 * Created by Mr_liang on 16/9/21.
 */
public class ReverString {
    public static void main(String[] args){
        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String s) {
        int length = s.length();
        StringBuffer reStr = new StringBuffer();
        String str[] = new String[length];
        str = s.split("");
        for(int i=length-1; i>=0; i--) {
            reStr.append(str[i]);
        }

        return reStr.toString();
    }
}
