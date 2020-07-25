package DoDoDo.array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangliang01 on 2019/9/29 using IDEA.
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Array_12_Integer_to_Roman {
    public String intToRoman(int num) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV",4);
        map.put("I", 1);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            //TODO 不要用 if(num >= value){
            while(num >= value){
                num -= value;
                sb.append(key);
            }
        }

        return sb.toString();

    }
}
