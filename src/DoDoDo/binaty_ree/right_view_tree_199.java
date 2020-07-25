package DoDoDo.binaty_ree;

import DoDoDo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangliang01 on 2020/7/24 using IDEA.
 *
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class right_view_tree_199 {

    //================================================常规1============================================================================//
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }

                if(curNode.left != null) {
                    queue.add(curNode.left);
                }

                if(i == 0) {
                    returnList.add(curNode.val);
                }
            }
        }

        return returnList;
    }

    //================================================常规2============================================================================//
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView_2(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        if(list.size() == depth) {
            list.add(node.val);
        }

        dfs(node.right, depth+1);
        dfs(node.left, depth+1);
    }
}

