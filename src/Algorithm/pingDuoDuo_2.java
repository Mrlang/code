package Algorithm;

import java.util.*;

/**
 * Created by Mr_liang on 2017/9/2 using IDEA.
 * 目录树
 输入：
 10
 my-app -1
 src 0
 main 1
 java 2
 resources 2
 webapp 2
 test 1
 java 2
 resources 2
 pom.xml 0
 */
public class pingDuoDuo_2 {
    public static HashMap<Integer, List<File>> map = new HashMap<>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int length = Integer.valueOf(sc.nextLine());
        for(int i=0; i<length; i++) {
            String[] str   = sc.nextLine().split(" ");
            int parent = Integer.valueOf(str[1]);
            if(parent == -1){
                List<File> a = new ArrayList<File>();
                a.add(new File( str[0], -1));
                map.put(0, a);
            }else {
                List<File> list = map.get(parent);
                File pf = list.get(list.size()-1);
                File f = new File(str[0], parent);
                pf.childs.add(f);

                List<File> l = map.get(parent+1);
                if(l == null){
                    l = new ArrayList<>();
                    l.add(f);
                    map.put(parent+1, l);
                }else {
                    l.add(f);
                }

            }

        }

        map.get(0).get(0).printChild("", false);
    }
}

class File implements Comparable<File>{
    public List<File> childs = new ArrayList<File>();
    public String name;
    public int parent;

    public File(String name, int parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public int compareTo(File o) {
        if(o.name.compareTo(name) > 0)
            return  -1;
        if (name.compareTo(o.name) > 0)
            return 1;
        return 0;
    }

    public void printChild(String prefix, boolean isLast){
        if(parent == -1) {
            System.out.println(name);
        } else {
            System.out.println(prefix + "-- " + name);
        }
        Collections.sort(childs);
        for(int i=0; i<childs.size(); i++) {
            if(parent == -1){
                if( i== childs.size()-1 ){
                    prefix = "`";
                    childs.get(i).printChild(prefix, true);
                }else{
                    prefix = "|";
                    childs.get(i).printChild(prefix, false);
                }

            }else{
                StringBuilder sb = new StringBuilder(" ");
                if( i== childs.size()-1 ){
                    for(int m=0; m<parent; m++) {
                        if(isLast)
                            sb.append("    ");
                        else
                            sb.append("   |");
                    }
                    prefix = sb.append("   `").toString();
                    childs.get(i).printChild(prefix, true);
                }else{
                    for(int m=0; m<parent; m++) {
                        if(isLast)
                            sb.append("    ");
                        else
                            sb.append("   |");
                    }
                    prefix = sb.append("   |").toString();
                    childs.get(i).printChild(prefix, false);
                }

            }

        }

    }
}
