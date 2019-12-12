package Algorithm.Offer;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Mr_liang on 2017/3/24 using IDEA.
 * offer面试题15: 找出链表中到数第k个节点
 */


public class class_15 {
    static Integer n = 1;
    public static void main(String args[]) {
        LinkNode head = LinkNode.getLink(10);
        LinkNode.printLink(head);
        int k=2;
//        findK(head, k);
        findK_with_2_point(head, k);
    }

    public static  void findK(LinkNode node, int k){
        if(node.next!=null)
            findK(node.next, k);
       if(n==k) {
           System.out.println(node.data);
           System.exit(0);
       }
       n++;

    }

    public static void findK_with_2_point(LinkNode node, int k){
        LinkNode point1 = node, point2 = node;

        for(int i=0; i< k-1; i++) {
            point1 = point1.next;
        }

        while (point1.next!=null){
            point1 = point1.next;
            point2 = point2.next;
        }

        System.out.println(point2.data);
    }


}

