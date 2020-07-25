package DoDoDo.binaty_ree;

import DoDoDo.TreeNode;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 124. 二叉树中的最大路径和
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class max_sum_path_124 {
    int returnMaxSum = Integer.MIN_VALUE;

    //================================================常规解法,背吧，有点不好想============================================================================//
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return returnMaxSum;
    }

    private int getMax(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left_max = Math.max(0, getMax(root.left));
        int right_max = Math.max(0, getMax(root.right));

        returnMaxSum = Math.max(returnMaxSum, left_max + right_max + root.val);

        return Math.max(left_max, right_max) + root.val;
    }
}
