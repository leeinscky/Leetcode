/* array | binary-search
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start

//美国站 讨论区第一
class Solution { 
    public int searchInsert(int[] nums, int target) { //二分查找
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2; // low<=mid, mid<high
            
            if (nums[mid] >= target)
                high = mid; // high always decreases (even high-low==1)
            else
                low = mid + 1; // low always increases
        }
        return low;
    }
}
/*
关于为什么返回low的解释 
https://leetcode.com/problems/search-insert-position/discuss/15080/My-8-line-Java-solution
见热评第一的讨论区
*/


// @lc code=end

/* 
//美国站讨论区-易于理解但是复杂度高。（二分法虽然难理解但是复杂度低）
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) //如果目标值属于数组里或者不大于数组里的最大值
                return i; //函数返回i
        }
        return nums.length; // 如果目标值大于数组里的最大值，函数不会执行那个if语句，因此只会返回nums.length，也就是相当于目标值插在数组的末尾。
    }
}
*/

/*  
缺点：Easy to understand. However, the running time of your algorithm is O(n) but
/* the one above is O(lg n).
