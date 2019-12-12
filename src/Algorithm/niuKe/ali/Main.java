package Algorithm.niuKe.ali;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        String pattern = sc.nextLine();

        Pattern p = Pattern.compile("\\?");
        Matcher m = p.matcher(pattern);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb, ".");
        }
        m.appendTail(sb);

        pattern = sb.toString();
        sb = new StringBuffer();
        p = Pattern.compile("\\*");
        m = p.matcher(pattern);
        while(m.find()){
            m.appendReplacement(sb, ".+");
        }
        m.appendTail(sb);


        boolean f = Pattern.matches(sb.toString(), content);
        sb=null;
        if(f)
            System.out.println("1");
        else
            System.out.println("0");
    }


}
