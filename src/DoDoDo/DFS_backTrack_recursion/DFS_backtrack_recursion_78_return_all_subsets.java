package DoDoDo.DFS_backTrack_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang01 on 2020/7/15 using IDEA.
 *
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DFS_backtrack_recursion_78_return_all_subsets {
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();

        recursion(curPath, 0, res);
        return res;

    }

    private void recursion(List<Integer> curPath, int curIndex, List<List<Integer>> res) {
        res.add(new ArrayList<>(curPath));
        for(int i=curIndex; i<nums.length; i++) {
            curPath.add(nums[i]);
            recursion(curPath, i+1, res);
            curPath.remove(curPath.size()-1);
        }
    }

}
