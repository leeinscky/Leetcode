/* linked-list
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 /* ？？没有完全弄懂
 * 法一: https://www.cnblogs.com/grandyang/p/4086297.html
 * 这道混合插入有序链表和我之前那篇混合插入有序数组非常的相似 Merge Sorted Array，仅仅是数据结构由数组换成了链表而已，
 * 代码写起来反而更简洁。具体思想就是新建一个链表，然后比较两个链表中的元素值，把较小的那个链到新链表中，
 * 由于两个输入链表的长度可能不同，所以最终会有一个链表先完成插入所有元素，则直接另一个未完成的链表直接链入新链表的末尾。
 * 代码如下：
 */

 /*
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
*/

/*
 * 法二: https://www.cnblogs.com/grandyang/p/4086297.html
 * 下面我们来看递归的写法，当某个链表为空了，就返回另一个。然后核心还是比较当前两个节点值大小，如果 l1 的小，那么对于 l1 的下一个节点和 l2
 * 调用递归函数，将返回值赋值给 l1.next，然后返回 l1；否则就对于 l2 的下一个节点和 l1 调用递归函数，将返回值赋值给
 * l2.next，然后返回 l2，参见代码如下：
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
    //问：方法声明里为什么没有void？答：因为此方法会返回一个链表类型（ListNode）的值，如果返回int类型的值，ListNode就会改为int
        
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) { //如果l1<l2，那么新链表的当前节点的值采用l1的节点值
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {   //如果l1>=l2，那么新链表的当前节点的值采用l2的当前节点值
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}


// @lc code=end


/* 解法二分析：
 * Input: 链表a：1->2->4, 链表b：1->3->4 Output: 1->1->2->3->4->4
 * 
 * 1. 首先链表a中的第一个节点的值1和链表b中的第一个节点的值1比较，因为相等，所以l2.next=mergeTwoLists(l1,l2.next)，
 * 也就是说返回l2的同时会让l2的下一个元素继续和l1比较。接下来的循环会让a中的第一个节点的值1和b中的第二个节点的值3比较，
 * 比较后：返回l1的同时会让l1的下一个元素继续和l2比较，因此b中的第一个节点（值为1）的地址指向l1。 也就是 1->1。
 * 
 * 2. 接下来，因为1<3,所以会让a中的第二个节点的值2和b中的第二个节点的值3比较，返回l1的同时会让l1的下一个元素继续和l2比较。
 * 因此a中的第一个节点（值为1）的地址仍然指向l1。也就是 1->1->2
 * 
 * 
 * 
 * 
 */