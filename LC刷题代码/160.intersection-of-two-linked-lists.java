/* linked-list
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 * 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。 如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。
 * 若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a +b
 * = b+a 。因此相遇处是NULL
 */
public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;   
            /* 以上两行可以替换为如下代码
            if (pA == null){
                pA = headB;
            }else{
                pA = pA.next;
            }
            if (pB ==null){
                pB = headA;
            }else{
                pB = pB.next;
            }
            */    
        }
        return pA; // 因为只有当pA==pB的时候，才会跳出 while (pA != pB) 循环，此时，返回pA和pB是一样的，因为相等。
        //而且pA此时只有两种情况：1. pA为相交点  2.pA为链表尾null

    }
}

/* 官方题解
 * 方法一: 暴力法 对链表A中的每一个结点 a_ia i ​ ，遍历整个链表 B 并检查链表 B 中是否存在结点和 a_ia i ​ 相同
 * 时间复杂度 : (mn)(mn)。 空间复杂度 : O(1)O(1)。
 * 
 * 方法二: 哈希表法遍历链表A并将每个结点的地址/引用存储在哈希表中。然后检查链表B中的每一个结点b_i是否在哈希表中。若在，则
 * b_i为相交结点。
 * 
 * 时间复杂度: O(m+n)。 空间复杂度: O(m)或 O(n)。
 * 
 * 方法三：双指针法 创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。 当 pApA
 * 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
 * 若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。 想弄清楚为什么这样可行, 可以考虑以下两个链表:
 * A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length
 * (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB
 * 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB
 * 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。 复杂度分析
 * 
 * 时间复杂度 : O(m+n)O(m+n)。 空间复杂度 : O(1)O(1)。
 */

// @lc code=end

