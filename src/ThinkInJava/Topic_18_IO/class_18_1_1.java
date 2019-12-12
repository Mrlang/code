package ThinkInJava.Topic_18_IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Mr_liang on 2017/2/24 using IDEA.
 */
public class class_18_1_1 {
    public static void main(String args[]) {
//        search("var");
        File f = new File("/");
        String[] list = f.list();
        List<String> a = Arrays.asList(list);
        System.out.println(a);
        for(int i=0; i< a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    static void listAll(){
        File f = new File("/");
        String[] list = f.list();
        System.out.println(f);
        for( String str : list) {
            System.out.println(str);
        }
    }

    static void search(final String preg){
        File f = new File("/");
        String[] list = f.list(new FilenameFilter() {
            private Pattern pat = Pattern.compile(preg);
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("file is "+dir+", name is "+name);
                return pat.matcher(name).matches();
            }
        });
        Arrays.sort(list);
        for( String str : list) {
            System.out.println("finish: find"+str);
        }
    }
}
