package DoDoDo.reverse_link;

import java.util.Stack;

/**
 * Created by wangliang01 on 2020/7/11 using IDEA.
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class reverse_whole_linklist_206 {

    // 自己想的一个非递归的遍历解法
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode curNode = head;
        curNode.next = null;
        while(nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = temp;
        }

        return curNode;
    }

    // TODO 答案里最优的非递归的遍历解法,值得记忆背诵,不需要考虑什么特殊情况处理,直接开始while循环,省心省力
    // 而且这个操作是很多其他链表题的基本操作，经常被用到
    public ListNode reverseList_best(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while(curNode != null) {
            ListNode temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }
        return preNode;
    }

    // TODO 一种比较优的递归遍历,大家说这个思路不太容易想到
    public ListNode backTrack(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode res = backTrack(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

    /**
     * TODO
     * 用栈实现也太low了
     * 很多一不小心没注意就才进去的坑点
     * 而且空间、时间复杂度也低
     * 真想不出来办法再用吧
     */
    public ListNode useQueue(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        if(head == null || head.next == null) {
            return head;
        }

        while(head != null) {
            stack.push(head);
            head = head.next;
        }


        ListNode newhead = null, last = null;
        while(!stack.isEmpty()) {
            if(last == null) {
                ListNode curPop = stack.pop();
                newhead = curPop;
                last = curPop;
            }else{
                last.next = stack.pop();
                last = last.next;
            }

        }
        last.next = null;

        return newhead;
    }

}
