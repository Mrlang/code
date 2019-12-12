package Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr_liang on 2017/9/26 using IDEA.
 */
public class lambdaTest {
    @Test
    public void a(){
        List list = Arrays.asList(1,2,3,4,5);
//        list.forEach(n -> System.out.println("this is " + n));

//        list.forEach(System.out::println);

//        list.stream().map((x) -> (Integer)x*(Integer) x).forEach(System.out::println);

        int sum = (Integer) list.stream().map((x) -> (Integer)x*(Integer) x).reduce((x,y) -> (Integer)x + (Integer) y).get();
        System.out.println(sum);
        list.forEach(System.out::println);
    }

    @Test
    public void test(){
        execute((a,b) -> {return a+b;});
    }

    public void execute(runInterface in){
        System.out.println("num is " + in.getNum(3,2));
    }
}

@FunctionalInterface
interface runInterface{
    int getNum(int a, int b);
}
