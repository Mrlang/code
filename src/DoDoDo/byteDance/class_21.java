package DoDoDo.byteDance;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 通过次数323,941提交次数509,923
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class class_21 {

    /*===============================================================常规解法,自己想出来了一点，统一处理和尾巴边界没有处理好，看了别人的额，背吧==============================================================*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode newHead = pre;

        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if(l1 == null) {
            pre.next = l2;
        }

        if(l2 == null) {
            pre.next = l1;
        }

        return newHead.next;
    }
}
