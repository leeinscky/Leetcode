/* string | dynamic-programming
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start

//链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
//解法 1: 暴力破解 暴力求解，列举所有的子串，判断是否为回文串，保存最长的回文串。  暴力求解的方法很好懂，但是很费时，都测不过
class Solution {
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) { //0对应len-1；1对应len-2
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if(test.length() > max && isPalindromic(test)){
                        max = test.length();
                        ans = s.substring(i, j);
                }
            }
        return ans;
    }
}
/*
 * 时间复杂度：两层 for 循环 O(n²）O(n²），for 循环里边判断是否为回文 O(n）O(n），所以时间复杂度为 O(n³）O(n³）。
 * 空间复杂度：O(1）O(1），常数个变量。
 */

// @lc code=end

