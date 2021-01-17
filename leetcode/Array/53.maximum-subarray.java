/* array | divide-and-conquer | dynamic-programming
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */


// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        // /sum只管往后加，变成负数就不继续加了，转而指向下一个数，然后重复同样的步骤往后加。
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum); //这个语句里ans不仅出现在结果也出现在max()里面。这就保证了ans可以始终记录下并保持求和计算得到的最大值
        }

        return ans;
    }
}

/*
 * 解释2：这道题可以这么想： 1.假如全是负数，那就是找最大值即可，因为负数肯定越加越大。
 * 2.如果有正数，则肯定从正数开始计算和，不然前面有负值，和肯定变小了，所以从正数开始。
 * 3.当和小于零时，这个区间就告一段落了，然后从下一个正数重新开始计算(也就是又回到 2 了)。而 dp 也就体现在这个地方。
 * 
 * 解释2:真的是太强了，我看的时候看不懂，自己动笔写了一列数才看懂ans和sum之间的关系。ans存储最大值，sum只管往后加，变成负数就不继续加了，
 * 转而指向下一个数，然后重复同样的步骤往后加。太妙了这想法。
 * 
 * 作者解释：思路 这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum
 * 保留并加上当前遍历数字 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字 每次比较 sum 和
 * ans的大小，将最大值置为ans，遍历结束返回结果 时间复杂度：O(n)
 * 
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa
 * -53-zui-da-zi-xu-he-by-guanpengchn/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

// @lc code=end

/*

//美国站讨论区第一 （使用动态规划方法，简写：dp）
class Solution {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

*/