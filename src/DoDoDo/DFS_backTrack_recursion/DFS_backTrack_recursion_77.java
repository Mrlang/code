package DoDoDo.DFS_backTrack_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang01 on 2020/7/15 using IDEA.
 *
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class DFS_backTrack_recursion_77 {
    private int size;
    private int maxNum;
    public List<List<Integer>> combine(int n, int k) {
        this.size = k;
        this.maxNum = n;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();

        recursion(curPath, 1, res);
        return res;
    }

    private void recursion(List<Integer> curPath, int curNum, List<List<Integer>> res) {
        if(curPath.size() == size) {
            res.add(new ArrayList<>(curPath));
            return;
        }

        for(int i=curNum; i<=maxNum; i++) {
            curPath.add(i);
            recursion(curPath, i+1, res);
            curPath.remove(curPath.size()-1);
        }
    }
}
