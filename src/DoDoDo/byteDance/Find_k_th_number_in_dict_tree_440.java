package DoDoDo.byteDance;

/**
 * Created by wangliang01 on 2020/7/19 using IDEA.
 *
 * 440. 字典序的第K小数字
 *
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Find_k_th_number_in_dict_tree_440 {
    public int findKthNumber(int max, int k) {
        long curPrefix = 1;  // 当期前缀的数值
        long curTh = 1;     // 当期前缀的数值再字典中的排位

        while (curTh < k) {
            long includedNodes = count_included_nodes_for_curPrefix(curPrefix, max);
            if(curTh + includedNodes > k) {
                curPrefix *= 10;
                curTh++;
            }else if(curTh + includedNodes <= k) {
                curPrefix ++;
                curTh += includedNodes;
            }
        }

        return (int)curPrefix;
    }

    // 若值为prefix，求其拥有多少个子节点(包括其自身)
    private long count_included_nodes_for_curPrefix(long curPrefix, int max) {
        long nextPrefix = curPrefix + 1;
        long includedNodes = 0;
        while(curPrefix <= max) {
            includedNodes += Math.min(max - curPrefix + 1, nextPrefix - curPrefix);
            curPrefix *= 10;
            nextPrefix *= 10;
        }

        return includedNodes;
    }

}
