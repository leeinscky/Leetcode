/* array
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start

class Solution {

    private int[] sum;// 前n为权重的和
    private Random random;// 随机生成器

    public Solution(int[] w) {  //构造函数
        random = new Random();
        sum = new int[w.length];

        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }

    }

    // 利用二分法找到当前随机数所在的区间,左闭右开
    // 按权重随机选择的实现方法就是，根据权重划分区域，然后生成随机数，找到随机数才在的区间
    public int pickIndex() {
        int value = random.nextInt(sum[sum.length - 1]) + 1;// 从 0 - sum[sum.length-1] + 1 随机生成一个随机数
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (sum[mid] == value) {
                return mid;
            } else if (sum[mid] > value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

