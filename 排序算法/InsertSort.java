import java.util.Arrays;
//直接插入排序   按顺序将数组中每个元素插入到数组左边已经排好的序列

/* https://blog.csdn.net/jianyuerensheng/article/details/51254415?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522158824748219724811813554%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=158824748219724811813554&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_v2~rank_v25-7
直接插入排序的基本操作是将一个记录插入到已经排好的有序表中，从而得到一个新的、记录数增1的有序表。对于给定的一组记录，初始时假定第一个记录自成一个有序序列，其余记录为无序序列。接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，直到最后一个记录插到有序序列中为止。
*/

public class InsertSort {
    public static void insertSort(int[] array) {
        int i, j, insertData;// 要插入的数据

        for (i = 1; i < array.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertData = array[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;

            while (j >= 0 && insertData < array[j]) {
                array[j + 1] = array[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            array[j + 1] = insertData;// 直到要插入的元素不小于第j个元素,将insertData插入到数组中

            System.out.println(Arrays.toString(array));
        }
    }


    public static void main(String[] args) {
        int array[] = { 12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2 };
        //int array[] = { 3 };
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

}