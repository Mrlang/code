package Algorithm.niuKe.tree;

/**
 * Created by Mr_liang on 2016/11/13.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class FindBinaryTreeDeep {
    public static void main(String args[]) {
        TreeNode t = new TreeNode(3);
        int a = TreeDepth_2(t);
        System.out.println(a);
    }

    //28MS, MEMARY 54K
   public static int TreeDepth(TreeNode pRoot) {
       int l,r;
       if(pRoot == null) {
           return 0;
       }else{
           l = TreeDepth(pRoot.left);
           r = TreeDepth(pRoot.right);
           return l >= r ? 1+l : 1+r;
       }
   }

    public static int TreeDepth_2(TreeNode pRoot) {
        return pRoot == null ? 0 : Math.max(1+TreeDepth_2(pRoot.left) , 1+TreeDepth_2(pRoot.right));
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}