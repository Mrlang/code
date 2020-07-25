package DoDoDo.byteDance;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 160. 相交链表
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO
 *  手动把两个指针走的路径构造成一样长度的路径
 *  如果中间遇到相等的节点，就满足while条件退出循环，返回节点
 *  如果没有，最后pa、pb都为null,下一次循环时 null == null, 退出循环，返回null
 *  所以所有情况都可以统一处理
 *  解法：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/gei-zi-ji-liu-ge-bi-ji-by-kkbill/
 */
public class intersection_node_in_linklist_160 {
    /*=================================================常规通用========================================================*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
