/* array | binary-search
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start

//美国站 讨论区第一
class Solution { 
    public int searchInsert(int[] A, int target) { //二分查找
        int low = 0, high = A.length;
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

// @lc code=end

//美国站讨论区
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i])
                return i;
        }
        return nums.length;
    }
}
// 缺点：Easy to understand. However, the running time of your algorithm is O(n) but
// the one above is O(lg n).
