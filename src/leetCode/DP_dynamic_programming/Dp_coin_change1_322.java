package leetCode.DP_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangliang01 on 2020/6/20 using IDEA.
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp_coin_change1_322 {
    private int[] coins;
    private Integer[] cache;

    public int coinChange_foolBackTrack(int[] coins, int amount) {
        this.coins = coins;
        return backTrack(amount);
    }

    public int coinChange_cache_from_top_to_bottom(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new Integer[amount+1];
        return cache_from_top_to_bottom(amount);
    }

    public int coinChange_cache_from_bottom_to_top(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new Integer[amount+1];
        return cache_from_bottom_to_top(amount);
    }

    
    private int backTrack(int amount) {
        if(amount < 0) {
            return -1;
        }

        if(amount == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            int subProblemRes = backTrack(amount - coins[i]);
            if(subProblemRes < 0) {
                continue;
            }
            min = Math.min(min, subProblemRes + 1);
        }

        if(min == Integer.MAX_VALUE) {
            return -1;
        }else {
            return min;
        }

    }

    private int cache_from_top_to_bottom(int amount) {
        if(amount < 0) {
            return -1;
        }

        if(amount == 0) {
            return 0;
        }

        if(cache[amount] != null) {
            return cache[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblemRes = cache_from_top_to_bottom(amount - coin);
            if(subProblemRes < 0) {
                continue;
            }
            min = Math.min(subProblemRes+1, min);
        }

        if(min == Integer.MAX_VALUE) {
            cache[amount] = -1;
        }else {
            cache[amount] = min;
        }

        return cache[amount];
    }

    private int cache_from_bottom_to_top(int amount) {
        Arrays.fill(cache, amount + 1);
        cache[0] = 0;
        for(int curAmount=0; curAmount<=amount; curAmount++) {
            for (int curCoin : coins) {
                if(curCoin > curAmount) {
                    continue;
                }

                cache[curAmount] = Math.min(cache[curAmount], cache[curAmount - curCoin] + 1);
            }
        }

        if(cache[amount] == amount + 1) {
            return -1;
        }else {
            return cache[amount];
        }

    }

    @Test
    public void test(){
        System.out.println(Integer.MAX_VALUE);
    }

}
