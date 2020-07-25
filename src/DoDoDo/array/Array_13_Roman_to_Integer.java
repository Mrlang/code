package DoDoDo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang01 on 2019/9/29 using IDEA.
 * 这题懂了就非常简单。首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Array_13_Roman_to_Integer {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if(s.length() == 1){
            return map.get(s.charAt(0));
        }

        int sum = 0;
        for(int i=0; i<s.length()-1; i++) {
            Integer value_1 = map.get(s.charAt(i));
            Integer value_2 = map.get(s.charAt(i+1));
            if(value_1 < value_2) {
                sum -= value_1;
            }else{
                sum += value_1;
            }
        }
        sum += map.get(s.charAt(s.length()-1));
        return sum;

    }
}
