/* binary-search | heap
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
*/

/*
//注意：这里的left mid right是数值，不是索引位置。
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

/* 解法2: 优先队列
思路分析：
https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/378java-er-fen-fa-tu-jie-you-xian-dui-lie-liang-ch/
要找第k小的元素，一种最常规的做法就是使用优先队列。
找第k小的元素，就保留k个最小的元素，其中最大的那个就是答案，所以可以使用最大优先队列。
遍历矩阵中的元素，将元素添加到队列中，如果队列中元素数目MaxPQ.size() > k，就将堆顶最大的元素弹出。
遍历结束后弹出堆顶元素，就是最小的k个元素中最大的，即第k小的元素。

这里可以利用矩阵的有序性做一点小的优化：
如果在遍历的过程中，队列中的元素数目已经为k了，且如果当前元素大于堆顶元素，这个元素放入队列中还会被弹出，所以就没必要放入。
并且遍历的内循环是从某一行的从左到右遍历，当前元素的右边元素比当前元素更大，也没必要放入队列，
所以当MaxPQ.size() == k && num > MaxPQ.peek()，直接打断内循环，进行下一行的遍历。

时间复杂度为O(n^2log(k))，空间复杂度为O(k)。
*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // PriorityQueue默认是一个小顶堆（堆顶到堆底从小到大），通过使用reverseOrder() 可以实现大顶堆(堆顶到堆底从大到小)
        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                if (MaxPQ.size() == k && num > MaxPQ.peek()) // peek() 用于在队列的头部查询元素
                    break;
                MaxPQ.add(num);
                if (MaxPQ.size() > k)
                    MaxPQ.remove();// 从队列中删除第一个元素
            }
        }
        return MaxPQ.remove();// 从队列中删除第一个元素 也就是矩阵中第k小的数
    }
}

/*
 * 2、poll()和remove()区别：
 * remove() 和 poll() 方法都是从队列中删除第一个元素。如果队列元素为空，调用remove() 的行为与 Collection
 * 接口的版本相似会抛出异常，但是新的 poll() 方法在用空集合调用时只是返回 null。因此新的方法更适合容易出现异常条件的情况。
 */

// @lc code=end

