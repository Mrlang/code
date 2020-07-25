package DoDoDo.reverse_link;

/**
 * Created by wangliang01 on 2020/7/11 using IDEA.
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverser_linklist_between_m_n_92 {
    // TODO 这个属于中等复杂的链表反转,需要两个递归函数
    public ListNode reverseBetween(ListNode head, int m, int n) {
        return reverser_between(head, m, n);
    }

    ListNode successor = null;

    // 反转以head开头的前N个节点
    private ListNode reverse_first_n_nodes(ListNode head, int n) {
        if(n==1) {
            successor = head.next;
            return head;
        }
        ListNode newHead = reverse_first_n_nodes(head.next, n-1);
        head.next.next = head;
        head.next = successor;

        return newHead;
    }

    private ListNode reverser_between(ListNode head, int m, int n) {
        if(m==1) {
            return reverse_first_n_nodes(head, n);
        }
        head.next = reverser_between(head.next, m-1, n-1);
        return head;
    }
}
