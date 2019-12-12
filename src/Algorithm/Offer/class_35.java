package Algorithm.Offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang01 on 2019/7/23 using IDEA.
 * 第一个只出现一次的字符
 * 在字符串中找出第一个只出现一次的字符。入输入"abaccdeff"，则输出b.
 */
public class class_35 {
    @Test
    public void test(){
        char[] chars = new char[]{'a', 'b', 'a', 'c', 'c', 'd', 'e', 'f', 'f'};
        char res = reslove(chars);
        System.out.println(res);
    }

    private char reslove(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if(map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            }else {
                map.put(aChar, 1);
            }
        }

        for (char aChar : chars) {
            if(map.get(aChar) == 1){
                return aChar;
            }
        }

        throw new RuntimeException("没有符合要求的");
    }



}
