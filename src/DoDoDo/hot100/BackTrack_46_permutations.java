package DoDoDo.hot100;

import java.util.*;
/**
 * Created by wangliang01 on 2020/6/17 using IDEA.
 *
 * 没有重复字符的全排列：
 *
 * 给定一个 [没有重复] 数字的序列，返回其所有可能的全排列。
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
public class BackTrack_46_permutations {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, List<Integer> curPath) {
        if(curPath.size() == nums.length) {
            /**
             * TODO
             * 在回溯中，当深度遍历到最底层，找到符合条件path的解加入到返回最终结果集的时候,
             * 一定重新构造一个新的path,不要直接把上层函数传进来的path引用作为正确结果直接返回,
             * 因为当本层函数执行结束回溯至上层调用函数的话，他的[递归后置事件-撤销选择]会对path数据进行回退,
             * 一直回退到最顶层函数，把path回退成空,
             * 导致打印出来时发现符合条件的path为空
             */
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
