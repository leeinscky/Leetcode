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

//官方解法  不能这样（来自讨论区）：本以为转变成两个整数相加更容易，却忽略了int溢出
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        //System.out.println("开始-dummyHead.val: " + dummyHead.val);

        ListNode p = l1, q = l2, curr = dummyHead;
        //System.out.print("开始p.val: " + p.val);
        //System.out.print("  " + p.next.val);
        //System.out.print("  " + p.next.next.val);
        //System.out.print("  开始q.val: " + q.val);
        //System.out.print("  " + q.next.val);
        //System.out.println("  " + q.next.next.val);

        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            //System.out.print("--------循环开始 第一个值x: " + x);
            //System.out.print("    第二个值y: " + y);
            //System.out.print("     进位值carry: " + carry);
            //System.out.println("     和sum: " + sum);

            carry = sum / 10;
            //System.out.println("用于下一次循环的进位值 carry = sum / 10: " + carry);

            curr.next = new ListNode(sum % 10); //通过 %10 我们可以逐个提取个位数。
            //System.out.println("新链表下一个节点值 curr.next.val: " + curr.next.val);

            curr = curr.next; //将curr链表的“指针”转移到下一个节点以便于我们对curr链表添加节点。
            //System.out.println("新链表当前节点值 curr.val: " + curr.val);

            if (p != null)
                p = p.next; //移动到l1链表的下一个节点
                //System.out.print("--------循环最后-p.val: " + p.val);

            if (q != null)  
                q = q.next; //移动到l2链表的下一个节点
                //System.out.println("     q.val: " + q.val);
        }

        if (carry > 0) { //如果最终的进位值carry大于0，例如234+766=1000中最后一次循环：2+7+1=10，就会多一位数。所以在这里单独判断
            ////System.out.println("最后-3-carry: " + carry);
            curr.next = new ListNode(carry);
            ////System.out.println("最后-curr.next.val: " + curr.next.val);
        }

        //System.out.println("结尾-dummyHead.next.val: " + dummyHead.next.val);
        return dummyHead.next;

    }

}


// @lc code=end

/* 
开始-dummyHead: 0
' +
  '开始p.val: 2  4  3  开始q.val: 5  6  4
' +
  '--------循环开始 第一个值x: 2    第二个值y: 5     进位值carry: 0     和sum: 7
' +
  '用于下一次循环的进位值 carry = sum / 10: 0
' +
  '新链表下一个节点值 curr.next.val: 7
' +
  '新链表当前节点值 curr.val: 7
' +
  '--------循环最后-p.val: 4     q.val: 6
' +



  '--------循环开始 第一个值x: 4    第二个值y: 6     进位值carry: 0     和sum: 10
' +
  '用于下一次循环的进位值 carry = sum / 10: 1
' +
  '新链表下一个节点值 curr.next.val: 0
' +
  '新链表当前节点值 curr.val: 0
' +
  '--------循环最后-p.val: 3     q.val: 4



' +
  '--------循环开始 第一个值x: 3    第二个值y: 4     进位值carry: 1     和sum: 8
' +
  '用于下一次循环的进位值 carry = sum / 10: 0
' +
  '新链表下一个节点值 curr.next.val: 8
' +
  '新链表当前节点值 curr.val: 8
*/