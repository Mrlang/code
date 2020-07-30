package DoDoDo.byteDance;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp_unique_paths_62 {
    /*=================================================常规通用，自己写的二维dp_cache[][]，还行吧========================================================*/
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[n][m];
        for(int i=0; i<n; i++) {
            cache[i][0] = 1;
        }

        for(int i=0; i<m; i++) {
            cache[0][i] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                cache[i][j] = cache[i-1][j] + cache[i][j-1];
            }
        }

        return cache[m-1][n-1];
    }
}
