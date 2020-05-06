/* math
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start

// 官方解答：https://leetcode.com/problems/reverse-integer/solution/
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {

            int pop = x % 10; // pop: x的个位数
            x /= 10; // 每次x pop出最后一位数以后就要除以10，然后继续%10得到倒数第二位数
            System.out.println("pop: " + pop);
            System.out.println("x: " + x);

            /*
             * pop > 7 pop < -8：-2147483648 to 2147483647 Because of the range see the last digit 
             * 7 and -8 are the last digits of Integer.MAX_VALUE and Integer.MIN_VALUE respectively.
             */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            /*
             * push 函数最终输出的rev的表达式就在这下面那行，也就是用这个语句之前的rev进行“rev * 10 + pop”的操作， rev * 10:
             * 最终结果 - 个位数 pop:最终结果的个位数 因此为了防止栈溢出，我们要满足: Integer.MIN_VALUE < rev * 10 + pop <
             * Integer.MAX_VALUE
             */
            rev = rev * 10 + pop;
            System.out.println("rev: " + rev);

        }
        return rev;
    }

    public void main(String[] args){
        Solution sol = new Solution(); // 在静态方法内部是不可以直接访问非静态成员的。
        int rev = sol.reverse(1234);
        System.out.println("最终结果 rev: " + rev);
    }

}


// @lc code=end


/*
pop: 4
x: 123
rev: 4

pop: 3
x: 12
rev: 43

pop: 2
x: 1
rev: 432

pop: 1
x: 0
rev: 4321

最终结果 rev: 4321

*/