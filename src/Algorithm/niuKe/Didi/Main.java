package Algorithm.niuKe.Didi;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/5/7 using IDEA.
 */
public class Main {
    static int count = 0;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        int n = new Integer(a[0]);
        int m = new Integer(a[1]);
        int map[][] = new int[n+2][m+2];
        for(int i=1; i<=n; i++){
            String temp = scanner.nextLine();
            for(int j=0; j<m; j++){
                map[i][j+1] = new Integer(String.valueOf(temp.charAt(j)));
            }
            temp = null;
        }


        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==1){
                    boolean res = setZero(i,j,map);
                    if(res == true)
                        count++;
                }
            }
        }


        System.out.println(count);
    }


    public static boolean setZero(int i, int j, int[][] map){
        map[i][j] = 0;
        if(i<map.length && j < map[0].length && map[i][j+1] == 1 )
            setZero(i,j+1,map);
        if(i<map.length && j < map[0].length && map[i][j-1] == 1 )
            setZero(i,j-1, map);
        if(i<map.length && j < map[0].length && map[i-1][j] ==1 )
            setZero(i-1,j,map);
        if(i<map.length && j < map[0].length && map[i+1][j] ==1 )
            setZero(i+1,j,map);

        return true;
    }

    @Test
    public void test(){
        String a = "asdfgf";
        String[] b = a.split("");
        System.out.println(b.length);
        System.out.println(b[3]);
        System.out.println(a.charAt(4));
    }
}
