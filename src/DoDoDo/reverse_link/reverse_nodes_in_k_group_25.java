package DoDoDo.reverse_link;

/**
 * Created by wangliang01 on 2020/7/11 using IDEA.
 *
 * 25.K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverse_nodes_in_k_group_25 {

    // TODO 这个属于最复杂的链表反转,需要两个递归函数
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverser_k_group(head, k);
    }

    /**
     * TODO
     * 反转head开头的整个链表,相当于反转从head节点到null节点,判断条件是while(cur != null);
     * 那么反转head开头到b的部分，判断条件就是while(cur != b), 其他操作一模一样
     */
    private ListNode reverse_until_b(ListNode head, ListNode b) {
        ListNode pre = null, cur = head, next = null;
        while(cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode reverser_k_group(ListNode head, int k) {
        ListNode a = head, b = head;
        for(int i=0; i<k; i++) {
            if(b == null) {
                return a;
            }else{
                b = b.next;
            }
        }

        ListNode newHead = reverse_until_b(head, b);
        a.next = reverser_k_group(b, k);
        return newHead;
    }
}
