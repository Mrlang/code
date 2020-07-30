package DoDoDo.byteDance;

import DoDoDo.DP_dynamic_programming.Dp_300_longest_increasing_subsequence;

/**
 * Created by wangliang01 on 2020/6/21 using IDEA.
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO
 *  这种dp问题，可以发现，需要使用递归和回溯，直接就是用自下而上的foreach才是最简单的
 *  然后要明确的是要解决的子问题是什么，也就是每个子问题dp_cache[i]代表什么
 *  代表的是：以nums[i]结束的所有连续数组中,最大和为dp_cache[i]
 *  ### 明确子问题是什么，
 *  1. 并不是： 简单地把题目最终所求问题缩小一步范围，就得到的子问题, 这样是不对的。比如本题,nums长度就9,最后一个下标为8，题目要求的是nums[0 ~8]中的最大和, 我们把子问题定义为 nums[0~7] ... nums[0~1] ... nums[0 ~0]中的最大和，那你不想想nums[1~7] .. nums[2~7]怎么版，不考虑了吗?
 *  2. 而是：   把符合题目要求的子数组作为子问题。比如本题, 条件是[最大和]的[连续的子数组], 也就是[连续子数组]中的[最大和], 那么把子问题表示为: 以nums[i]结束的所有连续子数组中的最大和存于dp[i]中
 *  3. 注意：   我说的是dp解字符串问题的时候，1这种方法不可取，解dp问题的其他场景比如背包问题，是可以的
 *
 *  TODO 对比和300做法
 *  @see Dp_300_longest_increasing_subsequence
 *
 */
public class Dp_53_maxsum_subarray {

    /*=================================================常规通用========================================================*/
    public int maxSubArray(int[] nums) {
        int dp_cache[] = new int[nums.length];
        dp_cache[0] = nums[0];

        // 依次解决每一个子问题
        for(int i=1; i< nums.length; i++) {
            // 把当前子问题可能的选择都做一遍，选出最优解
            dp_cache[i] = Math.max(nums[i], dp_cache[i-1] + nums[i]);
        }

        int max = nums[0];
        for(int i=0; i<dp_cache.length; i++) {
            max = Math.max(max, dp_cache[i]);
        }
        return max;
    }

    /*=================================================常规通用========================================================*/
    public int maxSubArray_better(int[] nums) {
        int dp_cache[] = new int[nums.length];
        dp_cache[0] = nums[0];

        int max = nums[0];
        // 依次解决每一个子问题
        for(int i=1; i< nums.length; i++) {
            // 把当前子问题可能的选择都做一遍，选出最优解
            dp_cache[i] = Math.max(nums[i], dp_cache[i-1] + nums[i]);
            max = Math.max(max, dp_cache[i]);
        }

        return max;
    }

    /*=================================================常规通用========================================================*/
    public int maxSubArray_best(int[] nums) {
        /**
         * TODO
         *  dp_cache用来保存子问题的解,不一定要用数组类型,也就是不一定非得把每个子问题的解都保存起来，
         *  先写出状态转移方程: curRes = Math.max(nums[i], lastSubRes + nums[i]);
         *  这种情况下，我们明显可以看出来：为了解决当前问题，其实就只需要保存上个子问题的解
         */
        int dp_cache = nums[0];
        int max = nums[0];

        for(int i=1; i< nums.length; i++) {
            dp_cache = Math.max(nums[i], dp_cache + nums[i]);
            max = Math.max(max, dp_cache);
        }

        return max;
    }


}
