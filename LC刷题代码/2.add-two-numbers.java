/* linked-list | math
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        System.out.println("开始-dummyHead: " + dummyHead.val);

        ListNode p = l1, q = l2, curr = dummyHead;
        System.out.print("开始p.val: " + p.val);
        System.out.print("  " + p.next.val);
        System.out.print("  " + p.next.next.val);
        System.out.print("  开始q.val: " + q.val);
        System.out.print("  " + q.next.val);
        System.out.println("  " + q.next.next.val);
        
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            System.out.print("--------循环开始 第一个值x: " + x);
            System.out.print("    第二个值y: " + y);
            System.out.print("     进位值carry: " + carry);
            System.out.println("     和sum: " + sum);

            carry = sum / 10;
            System.out.println("用于下一次循环的进位值 carry = sum / 10: " + carry);

            curr.next = new ListNode(sum % 10);
            System.out.println("新链表下一个节点值 curr.next.val: " + curr.next.val);

            curr = curr.next;
            System.out.println("新链表当前节点值 curr.val: " + curr.val);

            if (p != null)
                p = p.next; //移动到l1链表的下一个节点
                if(p.val != null)
                    System.out.print("--------循环最后-p.val: " + p.val);

            if (q != null)  
                q = q.next; //移动到l2链表的下一个节点
                if (q.val != null)
                    System.out.println("     q.val: " + q.val);

        }
        if (carry > 0) {
            System.out.println("最后-3-carry: " + carry);
            curr.next = new ListNode(carry);
            System.out.println("最后-curr.next.val: " + curr.next.val);

        }
        System.out.println("结尾-dummyHead.next.val: " + dummyHead.next.val);
        return dummyHead.next;

    }

}


// @lc code=end

