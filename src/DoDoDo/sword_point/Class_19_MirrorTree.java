package DoDoDo.sword_point;

import java.util.Random;

/**
 * Created by Mr_liang on 2017/3/24 using IDEA.
 * offer面试题19:二叉树镜像:给出一个树的根节点,返回该树镜面树的根节点
 */
public class Class_19_MirrorTree {
    public static void main(String args[]) {
        BinTreeNode head = BinTreeNode.generateNewTree(4,20,new Random(System.currentTimeMillis()));
        BinTreeNode.order(head, "mid", 2);
        getMirror(head);
        BinTreeNode.order(head, "mid", 2);
    }

    public static void  getMirror(BinTreeNode head1){
        swapLeftAndRight(head1);
        if(head1.left != null)
            getMirror(head1.left);

        if(head1.right != null)
            getMirror(head1.right);
    }

    public static void swapLeftAndRight(BinTreeNode node){
        BinTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static BinTreeNode getTest(){
        BinTreeNode left = new BinTreeNode(2,null,null);
        BinTreeNode right = new BinTreeNode(3,new BinTreeNode(4,null,null),null);
        BinTreeNode head = new BinTreeNode(1,left,right);
        return head;
    }
}
