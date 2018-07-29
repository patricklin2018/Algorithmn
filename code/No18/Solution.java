package No18;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/29 22:53
 * @Description:
 *
 * 剑指 Offer - 18 合并两个排序的链表
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode first = new ListNode(0);
        ListNode ptr = first;
        while (true) {
            if (list1 == null) {
                ptr.next = list2;
                break;
            }
            else if (list2 == null) {
                ptr.next = list1;
                break;
            }
            else if (list1.val <= list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            }
            else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        return first.next;
    }

    public static void main (String[] args) {
        ListNode a = new ListNode(1);
        ListNode ap = a;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(5);

        ListNode b = new ListNode(2);
        ListNode bp = b;
        b.next = new ListNode(4);
        b = b.next;
        b.next = new ListNode(6);

        new Solution().Merge(ap, bp);
    }
}
