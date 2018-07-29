## 18 - 合并两个排序的链表

### 题目描述

输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。

### 思路

对 `list1` 和 `list2` 进行如下判断：

```java
1，如果 list1 为空，ptr -> list2
2，否则如果 list2 为空，ptr -> lsit1
3，否则如果 list1.val <= list2.val，ptr -> list1
4，否则 list1.val > list2.val，ptr -> list2
```

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
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
}
```