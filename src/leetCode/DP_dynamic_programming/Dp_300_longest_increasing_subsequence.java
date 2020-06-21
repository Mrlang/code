package leetCode.DP_dynamic_programming;

import java.util.Arrays;

/**
 * Created by wangliang01 on 2020/6/21 using IDEA.
 *
 * TODO：(对比和53的做法)
 * 最长递增序列：
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp_300_longest_increasing_subsequence {
    /**
     * TODO
     *  这种dp问题，可以发现，需要使用递归和回溯，直接就是用自下而上的foreach才是最简单的
     *  然后要明确的是要解决的子问题是什么，也就是每个子问题dp_cache[i]代表什么
     *  代表的是：以nums[i]结束的最长递增子序列的长度为dp_cache[i]
     */
    public int lengthOfLIS(int[] nums) {
        int dp_cache[] = new int[nums.length];
        Arrays.fill(dp_cache, 1);

        // 依次解决每一个子问题
        for (int subProblem=0; subProblem<nums.length; subProblem++ ) {
            // 把当前子问题可能的选择都做一遍，选出最优解
            for(int j=0; j<subProblem; j++) {
                if(nums[subProblem] > nums[j]) {
                    dp_cache[subProblem] = Math.max(dp_cache[j] + 1, dp_cache[subProblem]);
                }
            }
        }

        int max_length = 0;
        for(int i=0; i<nums.length; i++) {
            max_length = Math.max(max_length, dp_cache[i]);
        }
        return max_length;
    }

    public int lengthOfLIS_better(int[] nums) {
        int dp_cache[] = new int[nums.length];
        Arrays.fill(dp_cache, 1);

        int max_length = 0;
        for (int subProblem=0; subProblem<nums.length; subProblem++ ) {
            for(int j=0; j<subProblem; j++) {
                if(nums[subProblem] > nums[j]) {
                    dp_cache[subProblem] = Math.max(dp_cache[j] + 1, dp_cache[subProblem]);
                }
            }

            max_length = Math.max(max_length, dp_cache[subProblem]);
        }

        return max_length;
    }

}
