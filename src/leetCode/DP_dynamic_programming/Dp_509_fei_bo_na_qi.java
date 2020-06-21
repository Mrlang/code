package leetCode.DP_dynamic_programming;

/**
 * Created by wangliang01 on 2020/6/20 using IDEA.
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp_509_fei_bo_na_qi {
    /**
     * 解法1：暴力解法
     * 一直向下递归，复杂度很高
     * TODO base case要放到backTrack里，
     *  if(N < 2) { return N; }
     *  这样当递归到base case就可以直接返回，不用再递归
     */
    public int fib_backTrack_no_cache(int N) {
        return backTrack(N);
    }

    Integer[] cache;

    /**
     * 解法2：
     * dp_cache_table + 自顶向下，既然是自顶向下，就必然需要向下递归，递归到最底层然后回溯
     * TODO base case提前在dp_cache_table中初始化好
     *  cache[0] = 0; cache[1] = 1;
     *
     */
    public int fit_cache_from_top_to_bottom(int N) {
        if(N < 2) {
            return N;
        }
        cache = new Integer[N+1];
        cache[0] = 0;
        cache[1] = 1;
        return from_top_to_bottom(N);
    }

    /**
     * 解法3：
     * dp_cache_table + 自底向上, 既然是自底向上，就需要递归和回溯，只需要foreach向上遍历
     *
     */
    public int fit_cache_from_bottom_to_top(int N) {
        if(N < 2) {
            return N;
        }
        cache = new Integer[N+1];
        cache[0] = 0;
        cache[1] = 1;
        return from_bottom_to_top(N);
    }

    private int fit_best(int N) {
        if(N < 2) {
            return N;
        }

        int last = 0;
        int cur = 1;

        for(int i=2; i<=N; i++) {
            int sum = last + cur;
            int temp = cur;
            cur = sum;
            last = temp;
        }
        return cur;
    }


    private int backTrack(int N) {
        if(N < 2) {
            return N;
        }
        return backTrack(N-1) + backTrack(N-2);
    }

    private int from_top_to_bottom(int n) {
        if(cache[n] != null) {
            return cache[n];
        }
        return from_top_to_bottom(n-1) + from_top_to_bottom(n-2);
    }

    private int from_bottom_to_top(int n) {
        for(int i=2; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }


}
