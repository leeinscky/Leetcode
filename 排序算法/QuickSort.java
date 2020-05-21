import java.util.Arrays;
//快速排序    挖坑填数 https://blog.csdn.net/MoreWindows/article/details/6684558

/* 快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，通常称其为分治法(Divide-and-ConquerMethod)。该方法的基本思想是：
1．先从数列中取出一个数作为基准数。
2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
3．再对左右区间重复第二步，直到各区间只有一个数。

对挖坑填数进行总结
1．i = L; j = R; 将基准数挖出形成第一个坑a[i]。
2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。

原文链接：https://blog.csdn.net/MoreWindows/article/details/6684558
*/

public class QuickSort{

    /* 1.0  此时打印输出：[2, 9, 4, 6, 8, 3, 7, 10, 5, 11, 1, 12, 13, 14, 14]

    public static int[] quick_sort( int numsArray[],  int left,  int right){//如果数组长度是10个，那么left=0，right=9
        if (left < right)
        {
            //Swap(numsArray[left], numsArray[(left + right) / 2]); //将中间的这个数和第一个数交换 有的书上是以中间的数作为基准数的，要实现这个方便非常方便，直接将中间的数和第一个数进行交换就可以了。
			int pivot = numsArray[left];
            while (left < right)
            //if (left < right)
            {
                while(left < right && numsArray[right] >= pivot){// 从右向左找第一个小于x的数
                    right--;  
                }
                numsArray[left] = numsArray[right];
                
                while(left < right && numsArray[left] < pivot){// 从左向右找第一个大于等于x的数
                    left++;  
                } 
                numsArray[right] = numsArray[left];
            }

            numsArray[left] = pivot;
            quick_sort(numsArray, left, left - 1); // 递归调用 
            quick_sort(numsArray, left + 1, right);
        }
        return numsArray;
    }
    */

    //2.0 此时打印输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]
    public static int[] quick_sort(int numsArray[], int left, int right) {// 如果数组长度是10个，那么left=0，right=9
        if (left < right) {// 如果if 换成while 会导致无法输出排序后的结果，因为 left<right 一直都成立
            // Swap(numsArray[left], numsArray[(left + right) / 2]); //将中间的这个数和第一个数交换
            // 有的书上是以中间的数作为基准数的，要实现这个方便非常方便，直接将中间的数和第一个数进行交换就可以了。
            int i = left, j = right, pivot = numsArray[left]; //将基准数挖出形成第一个坑a[i]
            while (i < j) //while 和 if 的区别：while 的条件只要一直满足，程序就会一直执行while里面的语句直至不满足以后才会退出循环
            // if (i < j)
            {
                while (i < j && numsArray[j] >= pivot) {//此while的作用：从右向左循环直到找到小于x的数 j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中
                    j--;
                }
                numsArray[i] = numsArray[j];//把小于基准数的元素调到左边

                while (i < j && numsArray[i] < pivot) {//此while的作用：从左向右循环直到找到大于等于x的数 i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中
                    i++;
                }
                numsArray[j] = numsArray[i];// 把大于基准数的元素调到右边
            } //退出此while循环时程序只做到了“基准数左边的数都 < 基准数，右边的数都 >= 基准数”。因此需要后续的语句来递归调用，继续对基准数左边/右边的所有数进行排序，

            // 再对左右区间重复第二步，直到各区间只有一个数。
            numsArray[i] = pivot; //如果删去下面的两行递归调用，输出结果：[2, 9, 4, 6, 8, 3, 7, 10, 5, 11, 1, 12, 13, 14, 14]，即只做到了“基准数左边的数都 < 基准数，右边的数都 >= 基准数”。
            quick_sort(numsArray, left, i - 1); // 递归调用，从最左边到第（i - 1）个数 进行快速排序
            quick_sort(numsArray, i + 1, right);// 递归调用，从第（i + 1）个数到最右边的数 进行快速排序
        }
        return numsArray;
    }


    public static void main( String[] args){
        int[] nums_array = {12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2};//打印输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]
        //int[] nums_array = {9, 6, 2}; //打印输出：[2, 6, 9]
        int left = 0, right = nums_array.length - 1;
        System.out.println( right );//打印输出：2 或者 14
        
        int[] sorted_result = QuickSort.quick_sort(nums_array, left, right); //因为quick_sort是静态方法，所以可以用类直接调用方法quick_sort
        System.out.println( Arrays.toString(sorted_result) ); //打印：[2, 6, 9] 或者 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]

    }
}
