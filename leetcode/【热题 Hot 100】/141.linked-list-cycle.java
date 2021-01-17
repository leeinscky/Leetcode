/* linked-list | two-pointers
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 * 方法一：哈希表 思路：我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
 * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点
 * null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回
 * true（即该链表为环形链表）。 
 * 时间复杂度：O(n)，对于含有n个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费O(1)的时间。
 * 空间复杂度：O(n)，空间取决于添加到哈希表中的元素数目，最多可以添加n个元素。
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) { //如果当前结点不是空结点null，就继续在循环内

            if (nodesSeen.contains(head)) {
                return true; //如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
            } else {
                nodesSeen.add(head);//如果当前结点的引用不存在于哈希表中，那么我们在哈希表中存储每个结点的引用（或内存地址）
            }

            head = head.next;// head.next是指head节点的下一个节点的引用，head.next.val指head的下一个节点的具体值
        }
        return false;//退出了while循环，说明当前结点为空结点null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
    }
}


/*
 * 方法二：双指针 思路
 * 想象一下，两名运动员以不同的速度在环形赛道上跑步会发生什么？∂∂
 * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至O(1)。慢指针每次移动一步，而快指针每次移动两步。
 * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
 * 现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。这是为什么呢？
 * 考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
 * 
 * 其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。但其实不难想到，因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) { //没有节点或者只有一个头节点
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) { //如果不是环形链表，快指针一定会先到达链表尾部造成fast.next==null,
                return false;
            }
            slow = slow.next;//慢指针每次移动一个位置
            fast = fast.next.next;//快指针每次移动两个位置
        }
        return true;//退出循环说明slow==fast，说明慢指针和快指针相遇了（只有环形链表才会导致相遇）
    }
}


// @lc code=end

