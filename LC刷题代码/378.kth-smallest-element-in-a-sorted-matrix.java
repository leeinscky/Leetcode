/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start

/*
思路：
1.找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间
2.mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count
3.若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间
4.若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间
5.因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right

注意：这里的left mid right是数值，不是索引位置。
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //lo:矩阵中最小的数 hi：矩阵中最大的数
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;// [lo, hi)
        while (lo < hi) {
            // mid：矩阵的中位数
            int mid = lo + (hi - lo) / 2; 
            int count = 0, j = matrix[0].length - 1;//假设矩阵是5x5，j=4

            // 在二维矩阵中寻找小于等于mid的元素个数count
            // 第一个for循环看成从上到下遍历矩阵的每一行
            for (int i = 0; i < matrix.length; i++) {
                //while循环看成对于矩阵的每一行，如果某个元素比中位数大就递减j，直到元素 <= 中位数，最后j的大小代表：这一行中比中位数小的元素个数-1，所以之后要+1
                while (j >= 0 && matrix[i][j] > mid)
                    j--; 
                //count加上当前遍历到的矩阵行的所有小于等于中位数的元素个数，遍历完所有行以后就会得到最终所有的小于等于中位数的元素个数
                count += (j + 1);
            }
            //若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间
            if (count < k) 
                lo = mid + 1;
            //若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间
            else
                hi = mid;
        }   
        // 因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right
        return lo;
    }
}
*/


/*
*/

class Solution {
    public int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int> pq;
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[0].size(); ++j) {
                pq.push(matrix[i][j]);
                if (pq.size() > k) pq.pop();
            }
        }
        return pq.top();
    }
}



// @lc code=end

