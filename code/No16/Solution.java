package No16;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/29 22:10
 * @Description:
 *
 * 剑指 offer - 16 链表中倒数第 k 个节点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 */

public class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }

        ListNode pre = head, aft = head;
        while (pre != null) {
            if (k > 0) {
                k--;
            }
            else {
                aft = aft.next;
            }
            pre = pre.next;
        }
        return k >= 1 ? null : aft;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        new Solution().FindKthToTail(first, 6);
    }
}
