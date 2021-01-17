/* string | backtracking
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

// 备注：结合官方题解里的图来理解更好
class Solution {
    Map<String, String> phone=new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            System.out.println("数字digit: " + digit);
            System.out.println("多个字母letters: " + letters);
            
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1); //代表输入的号码中每个数字对应的一串字符中的每一个字母
                System.out.println("单个字母letter: " + phone.get(digit).substring(i, i + 1) );

                System.out.println("用于下次迭代的参数1 combination + letter: " + combination + letter);
                System.out.println("用于下次迭代的参数2 next_digits.substring(1): " + next_digits.substring(1));

                // append the current letter to the combination and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1)); //运用迭代
            }
        }
    }

    public List<String> letterCombinations(String digits) {
    System.out.println("开始digits: " + digits);
    if (digits.length() != 0)
        backtrack("", digits);
    return output;
    }

}
/*
 * 方法：回溯 回溯是一种通过穷举所有可能情况来找到所有解的算法。如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，
 * 并重新尝试找到可行解。
 * 
 * 给出如下回溯函数 backtrack(combination, next_digits) ，它将一个目前已经产生的组合 combination
 * 和接下来准备要输入的数字 next_digits 作为参数。
 * 
 * 如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。 如果还有数字需要被输入： 遍历下一个数字所对应的所有映射的字母。
 * 将当前的字母添加到组合最后，也就是 combination = combination + letter 。 重复这个过程，输入剩下的数字：
 * backtrack(combination + letter, next_digits[1:]) 。
 */



// @lc code=end



/*

Your Input
"23"
Output (10 ms)
["ad","ae","af","bd","be","bf","cd","ce","cf"]
Expected Answer
["ad","ae","af","bd","be","bf","cd","ce","cf"]
Stdout
开始digits: 23
' +
  '数字digit: 2
' +
  '多个字母letters: abc
' +
  '单个字母letter: a
' +
  '参数1 combination + letter: a
' +
  '参数2 next_digits.substring(1): 3
' +
  '数字digit: 3
' +
  '多个字母letters: def
' +
  '单个字母letter: d
' +
  '参数1 combination + letter: ad
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: e
' +
  '参数1 combination + letter: ae
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: f
' +
  '参数1 combination + letter: af
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: b
' +
  '参数1 combination + letter: b
' +
  '参数2 next_digits.substring(1): 3
' +
  '数字digit: 3
' +
  '多个字母letters: def
' +
  '单个字母letter: d
' +
  '参数1 combination + letter: bd
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: e
' +
  '参数1 combination + letter: be
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: f
' +
  '参数1 combination + letter: bf
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: c
' +
  '参数1 combination + letter: c
' +
  '参数2 next_digits.substring(1): 3
' +
  '数字digit: 3
' +
  '多个字母letters: def
' +
  '单个字母letter: d
' +
  '参数1 combination + letter: cd
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: e
' +
  '参数1 combination + letter: ce
' +
  '参数2 next_digits.substring(1): 
' +
  '单个字母letter: f
' +
  '参数1 combination + letter: cf
' +
  '参数2 next_digits.substring(1): 

*/