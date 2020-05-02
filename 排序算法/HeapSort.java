import java.util.Arrays;
//堆排序  (堆排序是一种选择排序)

/*
我们完全可以把堆（以下全都默认为最大堆）看成一棵完全二叉树，但是位于堆顶的元素总是整棵树的最大值，每个子节点的值都比父节点小，由于堆要时刻保持这样的规则特性，
所以一旦堆里面的数据发生变化，我们必须对堆重新进行一次构建。

既然堆顶元素永远都是整棵树中的最大值，那么我们将数据构建成堆后，只需要从堆顶取元素不就好了吗？ 
第一次取的元素，是否取的就是最大值？取完后把堆重新构建一下，然后再取堆顶的元素，是否取的就是第二大的值？ 
反复的取，取出来的数据也就是有序的数据。
*/

public class HeapSort {

    public static void sort(int[] arr) {
        int length = arr.length;
        buildHeap(arr, length);// 原始序列构成的堆是无序的，根据给定的原始序列构建一个大顶堆，上面的节点值比下面的大
        System.out.println("成功构建堆以后的数组 arr:" + Arrays.toString(arr));

        for ( int i = length - 1; i > 0; i-- ) {
            System.out.println("i:" + i);
            System.out.println("元素下沉前的初始数组 arr:" + Arrays.toString(arr));

            //将堆顶元素与末位元素调换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            length--; // 数组长度-1 隐藏堆尾元素
            System.out.println("开始执行 sort 函数里的sink方法");
            sink(arr, 0, length); // 堆顶元素和末位元素互换以后的堆从有序变为了无序。因此要继续调用sink()函数将堆顶元素下沉 目的是将最大的元素浮到堆顶来

            System.out.println("此次i循环-元素下沉后的数组 arr:" + Arrays.toString(arr));
            System.out.println(" ");

        }
    }

    private static void buildHeap(int[] arr, int length) {
        for (int i = length / 2; i >= 0; i--) { //i:父节点 父节点逐渐变小，往数组的左边前进。使用循环的作用：因为构建堆的过程中 我们需要从下至上使得大元素往堆顶走，也就是往数组的左边走。

            System.out.println("开始构建堆- 执行buildHeap函数里的sink方法");
            sink(arr, i, length);
            System.out.println("构建堆过程中- 此次i循环以后的数组 arr:" + Arrays.toString(arr));
            System.out.println(" ");

        }
    }

    /**
     * 下沉调整
     * @param arr 数组
     * @param index 调整位置
     * @param length 数组范围
     */
    private static void sink(int[] arr, int index, int length) {
    
        int leftChild = 2 * index + 1;//左子节点下标
        int rightChild = 2 * index + 2;//右子节点下标
        int present = index;//要调整的节点下标
        System.out.print("index:" + index);
        System.out.print("   leftChild:" + leftChild);
        System.out.print("   rightChild:" + rightChild);
        //System.out.print("    arr[present]:" + arr[present]);
        //System.out.print("   arr[leftChild]:" + arr[leftChild]);
        //System.out.print("   arr[rightChild]:" + arr[rightChild]);

        if (leftChild < length && arr[leftChild] > arr[present]) { // 下沉左边
            present = leftChild;
        }
        
        if (rightChild < length && arr[rightChild] > arr[present]) { // 下沉右边
            present = rightChild;
        }

        System.out.println(" present:" + present);

        if (present != index) {// 如果下标不相等 证明调换过了
            //交换值
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;

            //继续下沉
            sink(arr, present, length);
        }

    }


    public static void main(String[] args) {
        int[] data = new int[] {  8, 2, 5, 9, 7, 3 };
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}

