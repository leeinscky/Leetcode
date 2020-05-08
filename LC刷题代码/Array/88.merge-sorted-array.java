/* array | two-pointers
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
import java.util.Arrays;


/*
 *中国站方法一 （暴力法）: 合并后排序
 *最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为O((n+m)log(n+m))。
 *这是由于这种方法没有利用两个数组本身已经有序这一点。
 */ 

/*
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //将nums2复制到nums1中，从nums2的位置0开始，复制到nums1的位置m，复制的长度为n。
        System.arraycopy(nums2, 0, nums1, m, n);// public static void arraycopy(Object src, int srcPos, Object dest, intdestPos, int length)
        Arrays.sort(nums1);
    }
}
*/


/*
 * 中国站方法二 : 双指针 / 从前往后 
 * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)O(n+m)的时间复杂度。
 * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
 * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要O(m) 的空间复杂度。
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2 and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n)){
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // if there are still elements to add
        if (p1 < m){
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n){
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}



/*
 * 中国站方法三 : 双指针 / 从后往前 
 * 方法二已经取得了最优的时间复杂度O(n +
 * m)O(n+m)，但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。
 * 如果我们从结尾开始改写 nums1 的值又会如何呢？这里没有信息，因此不需要额外空间。
 * 这里的指针 p 用于追踪添加元素的位置。
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang
 * -ge-you-xu-shu-zu-by-leetcode/ 来源：力扣（LeetCode） 
 */
/*
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2 
            // and add the largest one in nums1 
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
*/

// @lc code=end

