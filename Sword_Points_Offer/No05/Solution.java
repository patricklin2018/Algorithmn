package No05;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;

/**
 * @author PatrickLin
 * @date 2018/7/24 22:40
 * @description
 *
 * 剑指 offer - 05 从尾到头打印链表
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 **/

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        if (listNode == null) {
            return res;
        }

        printListFromTailToHead(listNode.next, res);
        res.add(listNode.val);

        return res;
    }

    public void printListFromTailToHead(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null) {
            return;
        }

        printListFromTailToHead(listNode.next, list);
        list.add(listNode.val);
    }
}
