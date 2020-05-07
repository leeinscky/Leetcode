/* array
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start

//美国站讨论区第一
class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        //从数组尾部开始向前循环遍历元素，如果元素值<9,就递增1；否则设为0
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) { 
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        //只有当输入数组内全部是9时才会执行以下语句return newNumber，其他所有情况
        //都会在for循环体里return digits
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

}



// @lc code=end

