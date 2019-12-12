package Java8;

/**
 * Created by Mr_liang on 2017/10/16 using IDEA.
 */
public class asd {
    public static void main(String args[]){
        System.out.println(aaa());
    }

    public static int aaa(){
        int j=1;
        int i = j++;
        try {
            i++;
            return i;
        }
        finally {
            i = i + 100;
            return i;
        }
    }
}
