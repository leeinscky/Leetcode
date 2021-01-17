import java.util.Arrays;

/* string | backtracking
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

/*
 * 方法一：暴力法 思路
 * 我们可以生成所有 2^{2n}2 2n 个 '(' 和 ')' 字符构成的序列，然后我们检查每一个是否有效即可。
 * 为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
 * 
 * 为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。如果在遍历过程中 balance
 * 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的。
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    //result:最终我们想要得到的结果(本质是一个列表，里面有不同元素，每个元素本身由括号组成的  
    //current: result 列表里面的单个元素，current形成后就会追加到result里面 
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            System.out.println("1: " + result);
            System.out.println("222: " + Arrays.toString(current));

            current[pos] = '(';

            System.out.println("3: " + result);
            System.out.println("444: " + Arrays.toString(current));

            generateAll(current, pos + 1, result);//第一次迭代

            System.out.println("5: " + result);
            System.out.println("666: " + Arrays.toString(current));
            
            current[pos] = ')';

            System.out.println("7: " + result);
            System.out.println("888: " + Arrays.toString(current));
            
            generateAll(current, pos + 1, result);

            System.out.println("9: " + result);
            System.out.println("101010: " + Arrays.toString(current));

        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

}

/* 打印输出
Your Input
3
Output (12 ms)
["((()))","(()())","(())()","()(())","()()()"]
Expected Answer
["((()))","(()())","(())()","()(())","()()()"]
Stdout
1: []
' +
  '222: [\u0000, \u0000, \u0000, \u0000, \u0000, \u0000]
' +
  '3: []
' +
  '444: [(, \u0000, \u0000, \u0000, \u0000, \u0000]
' +
  '1: []
' +
  '222: [(, \u0000, \u0000, \u0000, \u0000, \u0000]
' +
  '3: []
' +
  '444: [(, (, \u0000, \u0000, \u0000, \u0000]
' +
  '1: []
' +
  '222: [(, (, \u0000, \u0000, \u0000, \u0000]
' +
  '3: []
' +
  '444: [(, (, (, \u0000, \u0000, \u0000]
' +
  '1: []
' +
  '222: [(, (, (, \u0000, \u0000, \u0000]
' +
  '3: []
' +
  '444: [(, (, (, (, \u0000, \u0000]
' +
  '1: []
' +
  '222: [(, (, (, (, \u0000, \u0000]
' +
  '3: []
' +
  '444: [(, (, (, (, (, \u0000]
' +
  '1: []
' +
  '222: [(, (, (, (, (, \u0000]
' +
  '3: []
' +
  '444: [(, (, (, (, (, (]
' +
  '5: []
' +
  '666: [(, (, (, (, (, (]
' +
  '7: []
' +
  '888: [(, (, (, (, (, )]
' +
  '9: []
' +
  '101010: [(, (, (, (, (, )]
' +
  '5: []
' +
  '666: [(, (, (, (, (, )]
' +
  '7: []
' +
  '888: [(, (, (, (, ), )]
' +
  '1: []
' +
  '222: [(, (, (, (, ), )]
' +
  '3: []
' +
  '444: [(, (, (, (, ), (]
' +
  '5: []
' +
  '666: [(, (, (, (, ), (]
' +
  '7: []
' +
  '888: [(, (, (, (, ), )]
' +
  '9: []
' +
  '101010: [(, (, (, (, ), )]
' +
  '9: []
' +
  '101010: [(, (, (, (, ), )]
' +
  '5: []
' +
  '666: [(, (, (, (, ), )]
' +
  '7: []
' +
  '888: [(, (, (, ), ), )]
' +
  '1: []
' +
  '222: [(, (, (, ), ), )]
' +
  '3: []
' +
  '444: [(, (, (, ), (, )]
' +
  '1: []
' +
  '222: [(, (, (, ), (, )]
' +
  '3: []
' +
  '444: [(, (, (, ), (, (]
' +
  '5: []
' +
  '666: [(, (, (, ), (, (]
' +
  '7: []
' +
  '888: [(, (, (, ), (, )]
' +
  '9: []
' +
  '101010: [(, (, (, ), (, )]
' +
  '5: []
' +
  '666: [(, (, (, ), (, )]
' +
  '7: []
' +
  '888: [(, (, (, ), ), )]
' +
  '1: []
' +
  '222: [(, (, (, ), ), )]
' +
  '3: []
' +
  '444: [(, (, (, ), ), (]
' +
  '5: []
' +
  '666: [(, (, (, ), ), (]
' +
  '7: []
' +
  '888: [(, (, (, ), ), )]
' +
  '9: [((()))]
' +
  '101010: [(, (, (, ), ), )]
' +
  '9: [((()))]
' +
  '101010: [(, (, (, ), ), )]
' +
  '9: [((()))]
' +
  '101010: [(, (, (, ), ), )]
' +
  '5: [((()))]
' +
  '666: [(, (, (, ), ), )]
' +
  '7: [((()))]
' +
  '888: [(, (, ), ), ), )]
' +
  '1: [((()))]
' +
  '222: [(, (, ), ), ), )]
' +
  '3: [((()))]
' +
  '444: [(, (, ), (, ), )]
' +
  '1: [((()))]
' +
  '222: [(, (, ), (, ), )]
' +
  '3: [((()))]
' +
  '444: [(, (, ), (, (, )]
' +
  '1: [((()))]
' +
  '222: [(, (, ), (, (, )]
' +
  '3: [((()))]
' +
  '444: [(, (, ), (, (, (]
' +
  '5: [((()))]
' +
  '666: [(, (, ), (, (, (]
' +
  '... 531 more lines 
*/



// @lc code=end

/*
 * 方法二：回溯法 思路和算法
 * 方法一还有改进的余地：我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一
 * 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
 * 
 * 如果左括号数量不大于n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
