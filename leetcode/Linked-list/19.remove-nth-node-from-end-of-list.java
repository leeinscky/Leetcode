/* linked-list | two-pointers
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;//删除second节点的next节点，从而实现对倒数第n个节点的删除
        return dummy.next;
    }

}
/*
 * 思路：我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1
 * 步，而第二个指针将从列表的开头出发。现在，这两个指针被 n
 * 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第n
 * 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下个结点。
 * 
 * 
 * Dummy Node是链表问题中一个重要的技巧，中文翻译叫“哑节点”或者“假人头结点”。
 * 
 * Dummy node 是一个虚拟节点，也可以认为是标杆节点。Dummy node 就是在链表表头 head 前加一个节点指向 head，即 dummy
 * -> head。Dummy node 的使用多针对单链表没有前向指针的问题，保证链表的 head 不会在删除操作中丢失。
 * 
 * 所以，当链表的 head 有可能变化（被修改或者被删除）时，使用 dummy node 可以很好的简化代码，最终返回 dummy.next 即新的链表。
 * 个人理解，
 * 
 * 哑节点（dummy node）是初始值为NULL的节点，创建在使用到链表的函数中，可以起到避免处理头节点为空的边界问题的作用，减少代码执行异常的可能性。
 * 也就是说，哑节点的使用可以对代码起到简化作用（省略当函数的入口参数为空时的判断）。
 * 
 * 总结： 哑节点（dummy Node）是一个被人为创建的节点，虽然其内容为NULL，但是它在堆中有占有一定的空间。
 * 哑节点的使用可以避免边界问题的处理，达到简化代码与减少代码出错可能性的目的。
 */

// @lc code=end

