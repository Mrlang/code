package DoDoDo.sword_point;

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * Created by Mr_liang on 2017/8/13 using IDEA.
 */

//http://blog.csdn.net/derrantcm/article/details/46811835#comments
//TODO:求树中两个结点的最低公共祖先，树的结构要搞清楚：
//                                              1. 搜索二叉树；
//                                              2. 普通二叉树；
//                                              3. 普通多叉树;
//TODO:本类以普通多叉树为例
public class class_commonNode_50 {

    // /TODO:传进来一个树的根节点，和一个要找的目标节点target，返回从这个根节点到这个节点的链表路径
    public static void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }

        // 添加当前结点
        path.add(root);

        List<TreeNode> children = (List<TreeNode>) root.children();
        // 处理子结点
        for (TreeNode node : children) {

            if (node == target) {
                path.add(node);
                return;
            } else {
                getNodePath(node, target, path);
            }
        }

        // 现场还原
        path.remove(path.size() - 1);
    }

}
