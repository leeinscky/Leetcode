import java.util.Arrays;
//归并排序

/*
归并排序的原理：
将待排序的数组分成前后两个部分，再递归的将前半部分数据和后半部分的数据各自归并排序，得到的两部分数据，
然后使用merge合并算法（算法见代码）将两部分算法合并到一起。 
例如：如果N=1；那么只有一个数据要排序，N=2，只需要调用merge函数将前后合并，N=4，........... 
也就是将一个很多数据的数组分成前后两部分，然后不断递归归并排序，再合并，最后返回有序的数组。

归并排序的时间复杂度：
归并排序的最好、最坏和平均时间复杂度都是O(nlogn)，而空间复杂度是O(n)，
比较次数介于(nlogn)/2和(nlogn)-n+1，赋值操作的次数是(2nlogn)。
因此可以看出，归并排序算法比较占用内存，但却是效率高且稳定的排序算法。
*/

/*
工作原理：
（1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列 
（2）设定两个指针，最初位置分别为两个已经排序序列的起始位置 
（3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置 
（4）重复步骤3直到某一指针达到序列尾 
（5）将另一序列剩下的所有元素直接复制到合并序列尾
————————————————
版权声明：本文为CSDN博主「jianyuerensheng」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/jianyuerensheng/article/details/51262984
*/

public class MergeSort {

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        /*
         * 因为在合并的时候我们并不知道左右的两个数组哪个会剩余，所以为了确保不遗漏元素，我们对左右两个数组都执行移入新数组的操作。如果某一个数组内的元素是0，
         * 说明之前的指针已经移到了序列尾，所以并不会进入while循环。但是我们要把两个while都写上。这样如果左边序列有剩余就进入第一个while，
         * 如果右边序列有剩余就进入第二个while循环
         */

        // 把左边剩余的数移入数组 
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组temp中的所有数字元素覆盖a数组中的所有元素位置，因为temp只是个缓存，但我们想让a数组变化，所以要变化。如果不进行这一步，a数组从头到尾一直没变化，所以打印输出显示a数组一直都是原始数组的顺序，从头到尾没有变化。
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    public static void main(String[] args) {
        int a[] = { 12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}