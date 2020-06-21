package leetCode.DP_dynamic_programming;

import org.junit.Test;

/**
 * Created by wangliang01 on 2020/6/21 using IDEA.
 *
 * TODO :
 *  完整背包问题，参考518，贼像
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp_416_partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) {
            return false;
        }

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }
        int halfSum = sum/2;

        boolean cache[][] = new boolean[nums.length][halfSum+1];

        /**
         * TODO
         *  这个初始化有点不好理解
         */
        for(int i=0; i<nums.length; i++) {
            cache[i][0] = true;
        }

        /**
         * TODO
         *  边界条件或者说最小子问题，首先确定其解
         */
        for(int i=0; i<=halfSum; i++) {
            cache[0][i] = nums[0]==i;
        }

        /**
         * TODO
         *  第一个循环从1开始
         *  第二个循环从0开始
         */
        for(int i=1; i<nums.length; i++) {
            for(int curSum=0; curSum <=halfSum; curSum++) {
                if(curSum - nums[i] > 0) {
                    cache[i][curSum] = cache[i-1][curSum] || cache[i-1][curSum-nums[i]];
                }else if(curSum - nums[i] == 0){
                    cache[i][curSum] = true;
                }else {
                    cache[i][curSum] = cache[i-1][curSum];
                }
            }
        }

        return cache[nums.length-1][halfSum];
    }


    public boolean canPartition_1(int[] nums) {
        if(nums.length == 0) {
            return false;
        }

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }
        int halfSum = sum/2;

        boolean cache[] = new boolean[halfSum + 1];
        cache[0] = true;

        if(nums[0] <= halfSum) {
            cache[nums[0]] = true;
        }

        for (int i = 1; i < nums.length ; i++) {
            /**
             * TODO
             *  注意这个地方是倒序
             *  必须保证在填充下一层数组的过程中不会覆盖上一层数组中需要的数据
             */
            for(int curSum=halfSum; curSum>=0; curSum--) {
                if(curSum - nums[i] > 0) {
                    cache[curSum] = cache[curSum] || cache[curSum-nums[i]];
                }else if(curSum - nums[i] == 0){
                    cache[curSum] = true;
                }else {
                    cache[curSum] = cache[curSum];
                }
            }
        }
        return cache[halfSum];
    }


    @Test
    public void test(){
        int a[] = new int[0];
        canPartition(a);
    }
}
