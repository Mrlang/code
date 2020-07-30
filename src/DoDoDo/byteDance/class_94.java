package DoDoDo.byteDance;

import DoDoDo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class class_94 {
    /*===============================================================想到了用栈，但这个栈的具体用法太难项链，还是背吧==============================================================*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        TreeNode curNode = root;
        Deque<TreeNode> stack = new LinkedList<>();

        while(curNode != null || !stack.isEmpty()) {
            //TODO 这个地方用while和if 都可，if好理解一点
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                retList.add(curNode.val);
                curNode = curNode.right;
            }
        }

        /*
        while(curNode != null || !stack.isEmpty()) {
            //TODO 这个地方用while和if 都可，if好理解一点
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            retList.add(curNode.val);
            curNode = curNode.right;
        }
        */

        return retList;
    }
}