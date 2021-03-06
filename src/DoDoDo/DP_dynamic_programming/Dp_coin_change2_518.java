package DoDoDo.DP_dynamic_programming;

/**
 * Created by wangliang01 on 2020/6/21 using IDEA.
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 *
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO
 *      完整背包问题，linekTo
 *      @see Dp_416_partition_equal_subset_sum, 贼像
 */
public class Dp_coin_change2_518 {
    public int change(int amount, int[] coins) {
        if(amount==0) {
            return 1;
        }
        if(coins.length == 0) {
            return 0;
        }

        int dp_cache[][] = new int[coins.length][amount+1];

        /**
         * TODO
         *  边界条件或者说最小子问题，首先确定其解
         */
        for(int curAmount=0; curAmount<=amount; curAmount++) {
            if(curAmount % coins[0] == 0){
                dp_cache[0][curAmount] = 1;
            }else{
                dp_cache[0][curAmount] = 0;
            }
        }

        /**
         * TODO
         *  边界条件或者说最小子问题，首先确定其解
         */
        for(int coinIndex=0; coinIndex<coins.length; coinIndex++) {
            dp_cache[coinIndex][0] = 1;
        }

        /**
         * TODO
         *  第一个循环从1开始
         *  第二个循环从0开始
         */
        for(int curCoin=1; curCoin<coins.length; curCoin++) {
            for(int curAmount=0; curAmount<=amount; curAmount++) {
                if(curAmount-coins[curCoin]<0) {
                    dp_cache[curCoin][curAmount] = dp_cache[curCoin-1][curAmount];
                }else {
                    dp_cache[curCoin][curAmount] = dp_cache[curCoin-1][curAmount] + dp_cache[curCoin][curAmount-coins[curCoin]];
                }

            }
        }

        return dp_cache[coins.length-1][amount];
    }


    public int change_2(int amount, int[] coins) {
        if(amount==0) {
            return 1;
        }
        if(coins.length == 0) {
            return 0;
        }

        int dp_cache[] = new int[amount+1];

        /**
         * TODO
         *  边界条件或者说最小子问题，首先确定其解
         */
        dp_cache[0] = 1;
        for(int curAmount=0; curAmount<=amount; curAmount++) {
            if(curAmount % coins[0] == 0){
                dp_cache[curAmount] = 1;
            }else{
                dp_cache[curAmount] = 0;
            }
        }

        /**
         * TODO
         *  第二个循环是正序,默认就是在填充下一层数组的过程中不会覆盖上一层数组中需要的数据
         */
        for(int curCoin=1; curCoin<coins.length; curCoin++) {
            for(int curAmount=1; curAmount<=amount; curAmount++) {
                if(curAmount-coins[curCoin]<0) {
                    dp_cache[curAmount] = dp_cache[curAmount];
                }else {
                    dp_cache[curAmount] = dp_cache[curAmount] + dp_cache[curAmount-coins[curCoin]];
                }

            }
        }
        return dp_cache[amount];
    }

}
