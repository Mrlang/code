package DoDoDo.byteDance;

import DoDoDo.*;
/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class common_ancestor_236 {
    /*=================================================常规通用,直接背吧，稍微有点拗，但可以背========================================================*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        //TODO lowestCommonAncestor()代表
        TreeNode resInLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode resInRight = lowestCommonAncestor(root.right, p, q);

        //TODO 如果自己不是最小公共祖先，root.left也不是，那肯定就在root.right了
        if(resInLeft == null) {
            return resInRight;
        }

        if(resInRight == null) {
            return resInLeft;
        }

        //TODO 如果一个在root左边,一个root右边，那么root就是最小公共祖先不用找了。因为如果还要把root.left往下递归的话，root右边那个节点肯定不在root.left下面
        if(resInLeft != null && resInRight != null) {
            return root;
        }

        return root;
    }
}
