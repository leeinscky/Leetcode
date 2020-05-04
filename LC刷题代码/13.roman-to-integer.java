/* math | string
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = s.length()-1; i >=0; i--){
            char c = s.charAt(i);
            switch (c) {
                case 'I': //I:1
                    //如果res >= 5,那么res-1,否则res+1 因为考虑到特殊：I+V(5)=4 I+X(10)=9  
                    //问：为什么res>=5就可以了 答：因为I一般放在末尾，如果I后面还有值，就说明是4/9这两个特殊
                    res += (res >= 5 ? -1 : 1); // A ？ B：C ，意思就是如果A为真执行B，否则执行C
                    break;
                case 'V': //V:5
                    res += 5;
                    break;
                case 'X': //X:10
                    // 如果res >= 50,那么res-1,否则res+1 因为考虑到特殊：X+L(50)=40 和 X+C(100)=90
                    // 问：为什么res>=50就可以了 答：因为X的后面一般接<=10的数，如果X后面还有值，就说明是40/90这两个特殊
                    res += 10 * (res >= 50 ? -1:1);
                    break;
                case 'L': //L:50
                    res += 50;
                    break;
                case 'C': //C:100
                    // 如果res >= 500,那么res-1,否则res+1 因为考虑到特殊：C+D(500)=400 和 C+M(1000)=900
                    // 问：为什么res>=500就可以了 答：因为C的后面一般接<=100的数，如果C后面还有值，就说明是400/900这两个特殊
                    res += 100 * (res >=500 ? -1:1);
                    break;
                case 'D': //D:500
                    res += 500;
                    break;
                case 'M': //M:1000
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}

// @lc code=end

