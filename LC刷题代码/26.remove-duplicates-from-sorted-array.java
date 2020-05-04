/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j =1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

/*
参考：
https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0026-Remove-Duplicates-from-Sorted-Array/Article/0026-Remove-Duplicates-from-Sorted-Array.md

题目解析
使用快慢指针来记录遍历的坐标。

开始时这两个指针都指向第一个数字
如果两个指针指的数字相同，则快指针向前走一步
如果不同，则两个指针都向前走一步
当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数

 * 
 * 笔记：
 * 使用两个pointers，i 和 j。i是low rnner，j是fast runner。如果数组里的第j个数和第i个数一样,那么我们就直接
 * 跳过此次j循环，不执行语句(i的大小不会改变)；如果不一样，那么i++, 代表不重复的元素的个数+1，同时，将nums[j] 赋值给 nums[i].
 * 代表原始数组里的第i个元素更改为nums[j]，这一过程中也就把和前一位重复的元素变为一个不重复的元素了。
 * 分析：这一过程中我们也没有引入新数组，符合题目要求。
 * 
 * 官网：
 * Complexity analysis
 * 
 * Time complextiy : O(n). Assume that n is the length of array. Each of i
 * and j traverses at most n steps.
 * 
 * Space complexity : O(1).
 * 
 * Since the array is already sorted, we can keep two pointers ii and jj, where
 * ii is the slow-runner while jj is the fast-runner. As long as nums[i] =
 * nums[j]nums[i]=nums[j], we increment jj to skip the duplicate.
 * 
 * When we encounter nums[j] \neq nums[i]nums[j]  ​ =nums[i], the duplicate run
 * has ended so we must copy its value to nums[i + 1]nums[i+1]. ii is then
 * incremented and we repeat the same process again until jj reaches the end of
 * array.
 */

// @lc code=end

