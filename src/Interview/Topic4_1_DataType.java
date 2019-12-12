package Interview;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Mr_liang on 2016/12/7.
 */
public class Topic4_1_DataType {
    @Test
    public void test(){
        Integer integer = new Integer(12);
        System.out.println(integer);

        integer = Integer.valueOf(21);
        System.out.println(integer);

        int i = integer.intValue();
        System.out.println(i);

        System.out.println(1.0-0.42);
        System.out.println(sub(1.0,0.42));
    }

    public double sub(double a, double b){
        BigDecimal num1 = new BigDecimal(a);
        BigDecimal num2= BigDecimal.valueOf(b);
        return num1.subtract(num2).doubleValue();
    }

    @Test
    public void testBoolean(){
        boolean flag;
//        if(flag) System.out.println("flag is true");

        Boolean f = null;
//        if(f) System.out.println("flag is true");
    }
}
