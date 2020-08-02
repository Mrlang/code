package DoDoDo.byteDance;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 2. 两数相加(两个链接相加)
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * TODO
 *  对比88：合并两个有序数组
 */
public class Add_two_linkedList_2 {

    /*===============================================================常规解法，但别人对于链表节点为null的巧妙统一处理可以学习下==============================================================*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        // 代表当前位是否进位
        int flag = 0;

        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int curSum = val1 + val2 + flag;
            //TODO 这个求余计算可以的
            flag = curSum / 10;
            curSum = curSum % 10;
            curNode.next = new ListNode(curSum);
            curNode = curNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if(flag > 0) {
            curNode.next = new ListNode(flag);
        }

        return head.next;
    }
}
