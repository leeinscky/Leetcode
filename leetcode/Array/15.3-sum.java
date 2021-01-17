/* array | two-pointers
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

/*
//美国站热评第一
class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}
*/
/*
 * The idea is to sort an input array and then run through all indices of a
 * possible first element of a triplet. For each possible first element we make
 * a standard bi-directional 2Sum sweep of the remaining part of the array. Also
 * we want to skip equal elements to avoid duplicates in the answer without
 * making a set or smth like that.
 *
 */


//中国站讨论区
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);// 排序
        // 双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) // 若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于0，直接返回结果。
                return lists; 

            if (i > 0 && nums[i] == nums[i - 1]) // 对于重复元素：跳过，避免出现重复解
                continue;

            int curr = nums[i];
            int L = i + 1, R = len - 1; //令左指针 L=i+1，右指针R=n−1，当 L<R时，执行循环：
            while (L < R) { 
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) { // 当 nums[i]+nums[L]+nums[R]==0，执行循环，
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
                    while (L < R && nums[L + 1] == nums[L])
                        ++L;
                    while (L < R && nums[R - 1] == nums[R])
                        --R;
                    ++L;
                    --R;
                } else if (tmp < 0) { //若和小于0，说明nums[L] 太小，L右移
                    ++L; 
                } else { //若和大于 0，说明nums[R] 太大，R 左移
                    --R;
                }
            }
        }
        return lists;
    }
}
/*
 * 排序 + 双指针 本题的难点在于如何去除重复解。
 * 
 * 算法流程： 特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。 对数组进行排序。 遍历排序后数组： 若
 * nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。 对于重复元素：跳过，避免出现重复解 令左指针
 * L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环： 当
 * nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，
 * 去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移 若和小于 00，说明
 * nums[L]nums[L] 太小，LL 右移
 * 
 */



// @lc code=end

