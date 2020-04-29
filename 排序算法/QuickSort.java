import java.util.Arrays;
//快速排序

public class QuickSort{
    public static int[] quick_sort( int numsArray[],  int left,  int right){
        if (left < right)
        {
            //Swap(numsArray[left], numsArray[(left + right) / 2]); //将中间的这个数和第一个数交换 有的书上是以中间的数作为基准数的，要实现这个方便非常方便，直接将中间的数和第一个数进行交换就可以了。
			int pivot = numsArray[left];
            while (left < right)
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

    public static void main( String[] args){
        int[] nums_array = {12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2};//打印输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]
        //int[] nums_array = {9, 6, 2}; //打印输出：[2, 6, 9]
        int left = 0;
        int right = nums_array.length - 1;
        System.out.println( right );//打印输出：2 或者 14
        
        int[] sorted_result = QuickSort.quick_sort(nums_array, left, right); //因为quick_sort是静态方法，所以可以用类直接调用方法quick_sort
        System.out.println( Arrays.toString(sorted_result) ); //打印：[2, 6, 9] 或者 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]

    }

}
