package leetCode.array;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;
import org.omg.PortableInterceptor.INACTIVE;
import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang01 on 2019/10/15 using IDEA.
 */
public class Array_7_Reverse_Integer {
    public int reverse(int input) {
        int returnInt = 0;
        int pop = 0;
        while(input != 0) {
            pop = input % 10;
            input /= 10;
            if(returnInt > Integer.MAX_VALUE/10 || (returnInt == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }

            if(returnInt < Integer.MIN_VALUE/10 || (returnInt == Integer.MIN_VALUE/10 && pop < -8)) {
                return 0;
            }

            returnInt = returnInt*10 + pop;
        }

        return returnInt;
    }


}
