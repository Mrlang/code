package Algorithm.Offer;

import org.junit.Test;

/**
 * Created by wangliang01 on 2019/8/23 using IDEA.
 *
 * 给定一棵二叉树的根节点,获取这棵树的深度
 * 类比面试题25"二叉树中和为某一值的路径"
 * 附加题: 给定一颗二叉树根节点，判断其是否为平衡二叉树(先搞清平衡的概念:左右子树的高度差<=1)
 *
 * 本题和附加题的相似之处在于:都是通过递归,将重点推至子节点身上,先研究子节点,而不是直接看根节点是不是平衡
 */
public class class_39 {
    @Test
    public void test1(){
        BinTreeNode head = BinTreeNode.generateNewTree(5, 20);
        BinTreeNode.order(head, "pre", 1);
        System.out.println("height is " + getHeight(head));
    }

    @Test
    public void test2(){
        BinTreeNode head = BinTreeNode.generateNewTree(5, 20);

        System.out.println(isBanlance_2(head));
    }


    public int getHeight(BinTreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // 附加题解法1： 不是太好,先看根节点是否平衡就要先遍历整个树;然后又看左右子树是否平衡,又要分别遍历左右子树,这样两个左右子树就别重复遍历了一次
    public boolean isBalance_1(BinTreeNode node) {
        if(node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if(Math.abs(leftHeight - rightHeight) <= 1) {
            return isBalance_1(node.left) && isBalance_1(node.right);
        }


        return false;
    }

    public int getHeight_2(BinTreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight_2(node.left);
        int rightHeight = getHeight_2(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }


    public boolean isBanlance_2(BinTreeNode node) {
        return getHeight_2(node) != -1;
    }
}
