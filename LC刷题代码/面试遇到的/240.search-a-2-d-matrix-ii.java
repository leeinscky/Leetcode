/* binary-search | divide-and-conquer
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II 搜索二维矩阵 II
 */

// @lc code=start

/*
方法一：暴力法 对于每一行我们可以像搜索未排序的一维数组——通过检查每个元素来判断是否有目标值。
算法：这个算法并没有做到聪明的事情。我们循环数组，依次检查每个元素。
如果，我们找到了，我们返回 true。否则，对于搜索到末尾都没有返回的循环，我们返回 false。
此算法在所有情况下都是正确的答案，因为我们耗尽了整个搜索空间。
*/
/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
*/
//复杂度分析:时间复杂度: O(mn)。因为我们在n×m 矩阵上操作，总的时间复杂度为矩阵的大小 
//空间复杂度：O(1)，暴力法分配的额外空间不超过少量指针，因此内存占用是恒定的。


/*
方法二：二分法搜索
矩阵已经排过序，就需要使用二分法搜索以加快我们的算法。

算法：首先，我们确保矩阵不为空。那么，如果我们迭代矩阵对角线，从当前元素对列和行搜索，
我们可以保持从当前 (row,col)(row,col) 对开始的行和列为已排序。 因此，我们总是可以二分搜索这些行和列切片。

我们以如下逻辑的方式进行 : 在对角线上迭代，二分搜索行和列，直到对角线的迭代元素用完为止（意味着我们可以返回 false ）
或者找到目标（意味着我们可以返回 true ）。

binary search 函数的工作原理和普通的二分搜索一样,但需要同时搜索二维数组的行和列。
*/
/*
class Solution {
    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {//start:0,1,2
        int lo = start; // start:0,1,2
        //如果vertical=true，说明搜索列，hi=矩阵的列数-1 ；否则hi=矩阵行数-1
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column 行不变二分法搜索某列
                if (matrix[start][mid] < target) {//matrix[0][mid] matrix[1][mid] matrix[2][mid] 一共三行
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            
            } else { // searching a row 搜索某行
                if (matrix[mid][start] < target) {//matrix[mid][0] matrix[mid][1] matrix[mid][2] 一共三列
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals matrix.length:获取行数 matrix[0].length:获取列数
        // 二维数组可以理解为是一维数组，只不过他的各处的元素是特殊元素—–一维数组
        int shorterDim = Math.min(matrix.length, matrix[0].length);

        for (int i = 0; i < shorterDim; i++) {  //假设矩阵5行3列 shorterDim=3
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false; 
    }
}
*/

/*
 * 方法二如果不运行horizontalFound 只运行verticalFound Testcase [[5],[6]] 6 Answer false
 * Expected Answer true
 */


/*
 * 方法四： 因为矩阵的行和列是排序的（分别从左到右和从上到下），所以在查看任何特定值时，我们可以修剪O(m)或O(n)元素。
 * 
 * 算法： 首先，我们初始化一个指向矩阵左下角的(row，col)指针。然后，直到找到目标并返回 true（或者指针指向矩阵维度之外的
 * (row，col)为止，我们执行以下操作：
 * 1. 如果当前指向的值大于目标值，则可以 “向上” 移动一行。
 * 2. 否则，如果当前指向的值小于目标值，则可以移动一列。
 * 这样做永远不会删减正确的答案；因为行是从左到右排序的，所以我们知道当前值右侧的每个值都较大。
 * 因此，如果当前值已经大于目标值，我们知道它右边的每个值会比较大，就没有必要再往右移动了，应该向上移动一行
 * 
 * 也可以对列进行非常类似的论证：当前值的上侧肯定比当前值小，所以没必要向上移动一行，应该往右移动一列
 * 因此这种搜索方式将始终在矩阵中找到目标（如果存在）。
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left 指针初始化在左下角
        int row = matrix.length-1; //指向最后一行
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) { 
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }
        return false;
    }
}

/*
 * 时间复杂度：O(n+m)。 时间复杂度分析的关键是注意到在每次迭代（我们不返回 true）时，行或列都会精确地递减/递增一次。由于行只能减少
 * mm 次，而列只能增加 nn 次，因此在导致 while 循环终止之前，循环不能运行超过 n+mn+m
 * 次。因为所有其他的工作都是常数，所以总的时间复杂度在矩阵维数之和中是线性的。
 * 空间复杂度：O(1)，因为这种方法只处理几个指针，所以它的内存占用是恒定的。
 */


// @lc code=end

