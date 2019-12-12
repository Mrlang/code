package ThinkInJava.Topic_21_Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mr_liang on 2017/2/22 using IDEA.
 */
public class class_21_3_5 {
    public static void main(String args[]) {
        List<String> l = Collections.synchronizedList(new ArrayList<String>());
        l.add("string1");
        l.get(0);
    }
}
