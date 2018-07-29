package No17;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/29 22:32
 * @Description:
 *
 * 剑指 offer - 17 反转链表
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode lst = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = lst;
            lst = head;
            head = tmp;
        }
        return lst;
    }
}
