package DoDoDo.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by wangliang01 on 2020/7/4 using IDEA.
 */
public class BFS_752_open_the_lock_box {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(int i=0; i<deadends.length; i++) {
            deads.add(deadends[i]);
        }

        int depth = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curString = queue.poll();
                if(curString.equals(target)) {
                    return depth;
                }
                if(deads.contains(curString)) {
                    continue;
                }
                for(int change=0; change<target.length(); change++) {
                    String plusededStr = plusStr(curString, change);
                    if(!visited.contains(plusededStr)) {
                        queue.add(plusededStr);
                        visited.add(plusededStr);
                    }

                    String minusedStr = minusStr(curString, change);
                    if(!visited.contains(minusedStr)) {
                        queue.add(minusedStr);
                        visited.add(minusedStr);
                    }
                }
            }
            depth++;
        }

        return -1;
    }

    private String plusStr(String str, int i) {
        char[] charArray = str.toCharArray();
        if(charArray[i] != '9') {
            charArray[i]++;
        }else{
            charArray[i] = '0';
        }

        return new String(charArray);
    }

    private String minusStr(String str, int i) {
        char[] charArray = str.toCharArray();
        if(charArray[i] == '0') {
            charArray[i] = '9';
        }else{
            charArray[i]-- ;
        }

        return new String(charArray);
    }
}
