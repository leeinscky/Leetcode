import java.util.Arrays;
//计数排序

/*
计数排序是一种非基于比较的排序算法，我们之前介绍的各种排序算法几乎都是基于元素之间的比较来进行排序的，计数排序的时间复杂度为 O(n + m )，m 指的是数据量，
说的简单点，计数排序算法的时间复杂度约等于 O(n)，快于任何比较型的排序算法。
*/

public class CountSort {

    public static void sort(int[] arr) {
        // 找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 初始化计数数组 创建一个最大下标为 max 的空数组 countArr 。(因为我们默认数组可能有0)
        int[] countArr = new int[max + 1];

        // 计数 遍历数据，将数据的出现次数填入 countArr 中对应的下标位置中。
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]] = countArr[arr[i]] + 1;  
            arr[i] = 0;//每次遍历一个元素以后会把该位置的元素置0
            //System.out.println("countArr: " + Arrays.toString(countArr));
        }

        // 排序 遍历 countArr ，将数据依次取出即可。
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                arr[index++] = i;
            }
            //System.out.println("arr: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] { 12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2 };
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}

/* 打印输出结果
countArr: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
countArr: [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0]
countArr: [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1]
countArr: [0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1]
countArr: [0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 2]
countArr: [0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 2]
countArr: [0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 2]
countArr: [0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 2]
countArr: [0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 2]
countArr: [0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 2]
countArr: [0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 2]
countArr: [0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2]
countArr: [0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
countArr: [0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
countArr: [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
arr: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 0]
arr: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0]

*/