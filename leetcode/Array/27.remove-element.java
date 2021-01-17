/* array | two-pointers
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start

//解法1 双指针
class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}

/*
 * 第一种思路 标签：拷贝覆盖 主要思路是遍历数组nums，每次取出的数字变量为num，同时设置一个下标ans
 * 在遍历过程中如果出现数字与需要移除的值不相同时，则进行拷贝覆盖nums[ans] = num，ans自增1
 * 如果相同的时候，则跳过该数字不进行拷贝覆盖，最后ans即为新的数组长度
 * 这种思路在移除元素较多时更适合使用，最极端的情况是全部元素都需要移除，遍历一遍结束即可 时间复杂度：O(n)，空间复杂度：O(1)
 * 
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/remove-element/solution/hua-jie-suan-fa-
 * 27-yi-chu-yuan-su-by-guanpengchn/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

// @lc code=end

/*
//解法2:
class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans;) {
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
*/

/*
 * 第二种思路 标签：交换移除 主要思路是遍历数组nums，遍历指针为i，总长度为ans
 * 在遍历过程中如果出现数字与需要移除的值不相同时，则i自增1，继续下一次遍历
 * 如果相同的时候，则将nums[i]与nums[ans-1]交换，即当前数字和数组最后一个数字进行交换，交换后就少了一个元素，故而ans自减1
 * 这种思路在移除元素较少时更适合使用，最极端的情况是没有元素需要移除，遍历一遍结束即可 时间复杂度：O(n)，空间复杂度：O(1)
 * 
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/remove-element/solution/hua-jie-suan-fa-
 * 27-yi-chu-yuan-su-by-guanpengchn/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
