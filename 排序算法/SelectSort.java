import java.util.Arrays;

public class SelectSort {

    public static void selectSort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        for (int currentIndex = 0; currentIndex < array.length-1; currentIndex++) {
            int tempValue = array[currentIndex], miniValueIndex = currentIndex; 
            // 将当前值 赋值给 缓存值（用于之后的数来和缓存值进行大小比较） 
            // 将当前下标 定义为 最小值下标（因为我们还没找到最小值，所以先用当前值 作为 最小值）
            
            for (int j = currentIndex + 1; j < array.length; j++) {
                if (array[j] > tempValue) {// array[j] < tempValue 从小到大排序；a[j] > tempValue 从大到小排序
                    tempValue = array[j]; //将最小值缓存到tempValue
                    miniValueIndex = j; // 如果有小于当前最小值的关键字将此关键字的下标赋值给miniValueIndex
                }
            }

            if (miniValueIndex != currentIndex) { // 将数组里的最小值和当前循环到的数 交换，因为从当前数从最左边开始循环，所以也就是把最小值放在数组的最前面，然后逐步往数组的后面推进。
                array[miniValueIndex] = array[currentIndex]; //当前值 赋值给 最小值所在位置： 将当前循环到的（当前值）赋值给 搜索到的最小值所在的位置（最小值所在的位置）
                array[currentIndex] = tempValue; //最小值 赋值给 当前值所在的位置
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int array[] = { 12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2 };
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
