package leetCode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang01 on 2020/6/17 using IDEA.
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hot_46_permutations {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, List<Integer> curPath) {
        if(curPath.size() == nums.length) {
            List<Integer> list = new ArrayList<>(curPath);
            res.add(list);
        }

        for(int i=0; i<nums.length; i++) {
            if(curPath.contains(nums[i])) {
                continue;
            }

            curPath.add(nums[i]);
            backTrack(nums, curPath);
            curPath.remove(curPath.size()-1);
        }
    }

}
