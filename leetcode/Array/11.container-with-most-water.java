/* array | two-pointers
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start

//官方题解-双指针法
public class Solution {
    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1; //初始化时：左边竹条在最开始0处，右边竹条是右边的最后一个
        int ans = 0; 
        while (l < r) { 
            int area = Math.min(height[l], height[r]) * (r - l); //求面积（长度是两个竹条之间的距离，高度取决于最短的那个竹条）
            ans = Math.max(ans, area); //每次记录两个竹条可以盛的水的面积的最大值

            if (height[l] <= height[r]) { //如果左边的竹条高度小于等于右边
                ++l; //递增左边的竹条
            }
            else {
                --r; //如果左边的竹条高度大于右边，递减右边的竹条
            }
        }
        return ans;
    }
}

// @lc code=end

