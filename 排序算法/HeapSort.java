import java.util.Arrays;
//堆排序 (堆排序是一种选择排序)  大顶堆的顶是数组中最大的元素，每次从顶来提取元素可以保证提取的数组成的数组有序

/*
我们完全可以把堆（以下全都默认为最大堆）看成一棵完全二叉树，但是位于堆顶的元素总是整棵树的最大值，
每个子节点的值都比父节点小，由于堆要时刻保持这样的规则特性，
所以一旦堆里面的数据发生变化，我们必须对堆重新进行一次构建。

既然堆顶元素永远都是整棵树中的最大值，那么我们将数据构建成堆后，只需要从堆顶取元素。 
第一次取的元素，就是最大值 取完后把堆重新构建一下，然后再取堆顶的元素，取的就是第二大的值。 
反复的取，取出来的数据也就是有序的数据。
*/

public class HeapSort {

    public static void sort(int[] arr) {
        int length = arr.length;
        buildHeap(arr, length);// 原始序列构成的堆是无序的，根据给定的原始序列构建一个大顶堆，上面的节点值比下面的大

        for (int i = length - 1; i > 0; i--) {
            // 将堆顶元素arr[0] 与末位元素arr[i] 调换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            length--; // 数组长度-1 隐藏堆尾元素

            sink(arr, 0, length); 
            // 堆顶元素和末位元素互换以后的堆从有序变为了无序。通过继续调用sink()函数将长度减少1的新数组进行排序构成大顶堆（父节点都比孩子节点的值大）
            // 由于堆要时刻保持一个规则特性：每个子节点的值都比父节点小，所以一旦堆里面的数据发生变化，我们必须对堆重新进行一次构建（通过sink函数重新构建）
            // sink函数使用0参数的原因：重新构建大顶堆的时候我们从上（顶）至下（底）开始构建
        }
    }

    private static void buildHeap(int[] arr, int arrayLength) {
        // i:父节点 父节点逐渐变小，往数组的左边前进。使用循环的作用：因为构建堆的过程中 我们需要从下至上使得大元素往堆顶走，也就是往数组的左边走。
        for (int i = arrayLength / 2; i >= 0; i--) {
            sink(arr, i, arrayLength);
        }
    }
    
    // arr数组  index调整位置  arrayLength数组范围
    private static void sink(int[] arr, int index, int arrayLength) {

        int leftChild = 2 * index + 1;// 左子节点下标
        int rightChild = 2 * index + 2;// 右子节点下标
        int present = index;// 要调整的节点下标

        if (leftChild < arrayLength && arr[present] < arr[leftChild] ) { // 下沉左边：如果当前节点< 左子节点。将当前节点和左子节点互换位置
            present = leftChild;
        }

        if (rightChild < arrayLength && arr[present] < arr[rightChild]) { // 下沉右边
            present = rightChild;
        }

        if (present != index) {// 如果下标不相等 证明下标调换过了，但是我们还没有调换下标对应的值，所以我们调换 arr[index] 和 arr[present]
            // 交换值 交换arr[index] 和 arr[present]
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;

            sink(arr, present, arrayLength);// 继续下沉
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] { 8, 2, 5, 9, 7, 3 };
        sort(data);
    }

}

/* 打印输出版
public class HeapSort {

    public static void sort(int[] arr) {
        int length = arr.length;
        buildHeap(arr, length);// 原始序列构成的堆是无序的，根据给定的原始序列构建一个大顶堆，上面的节点值比下面的大
        //System.out.println("成功构建堆以后的数组 arr:" + Arrays.toString(arr));
        //System.out.println(" ");

        for ( int i = length - 1; i > 0; i-- ) {
            //System.out.println("数组长度 i = " + i);
            //System.out.println("元素下沉前的初始数组 arr:" + Arrays.toString(arr));

            //将堆顶元素与末位元素调换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            length--; // 数组长度-1 隐藏堆尾元素
            //System.out.println("开始执行 sort 函数里的sink方法");
            //System.out.println("元素下沉前 堆顶堆尾互换后的数组 arr:" + Arrays.toString(arr));
            
            sink(arr, 0, length); // 堆顶元素和末位元素互换以后的堆从有序变为了无序。通过继续调用sink()函数将长度减少1的新数组进行排序构成大顶堆（父节点都比孩子节点的值大）由于堆要时刻保持一个规则特性：每个子节点的值都比父节点小，所以一旦堆里面的数据发生变化，我们必须对堆重新进行一次构建（通过sink函数重新构建）
            //sink函数使用0参数的原因：重新构建大顶堆的时候我们从上（顶）至下（底）开始构建
            //System.out.println("此次i循环-元素下沉后的数组 arr:" + Arrays.toString(arr));
            //System.out.println(" ");

        }
    }

    private static void buildHeap(int[] arr, int length) {
        //i:父节点 父节点逐渐变小，往数组的左边前进。使用循环的作用：因为构建堆的过程中 我们需要从下至上使得大元素往堆顶走，也就是往数组的左边走。
        for (int i = length / 2; i >= 0; i--) { 
            //System.out.println("开始构建堆- 执行buildHeap函数里的sink方法");
            sink(arr, i, length);
            //System.out.println("构建堆过程中- 此次i循环以后的数组 arr:" + Arrays.toString(arr));
            //System.out.println(" ");
        }
    }
*/

    /**
     * 下沉调整
     * @param arr 数组
     * @param index 调整位置
     * @param length 数组范围
     */

/*
    private static void sink(int[] arr, int index, int length) {
    
        int leftChild = 2 * index + 1;//左子节点下标
        int rightChild = 2 * index + 2;//右子节点下标
        int present = index;//要调整的节点下标
        //System.out.print("index:" + index);
        //System.out.print("   leftChild:" + leftChild);
        //System.out.print("   rightChild:" + rightChild);
        //System.out.print("    arr[present]:" + arr[present]);
        //System.out.print("   arr[leftChild]:" + arr[leftChild]);
        //System.out.print("   arr[rightChild]:" + arr[rightChild]);

        if (leftChild < length && arr[leftChild] > arr[present]) { // 下沉左边：将当前节点和左子节点互换位置
            present = leftChild;
        }
        
        if (rightChild < length && arr[rightChild] > arr[present]) { // 下沉右边
            present = rightChild;
        }

        //System.out.print("    present:" + present);

        if (present != index) {// 如果下标不相等 证明下标调换过了，但是我们还没有调换下标对应的值，所以我们调换 arr[index] 和 arr[present]
            //交换值 交换arr[index] 和 arr[present]
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;

            //System.out.println(" 更新后的arr:" + Arrays.toString(arr));
            
            //继续下沉
            sink(arr, present, length);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] {  8, 2, 5, 9, 7, 3 };
        sort(data);
        //System.out.println(Arrays.toString(data));
    }

}
*/


/*

开始构建堆- 执行buildHeap函数里的sink方法
index:3   leftChild:7   rightChild:8    present:3 
构建堆过程中- 此次i循环以后的数组 arr:[8, 2, 5, 9, 7, 3]
 
开始构建堆- 执行buildHeap函数里的sink方法
index:2   leftChild:5   rightChild:6    present:2
构建堆过程中- 此次i循环以后的数组 arr:[8, 2, 5, 9, 7, 3]
 
开始构建堆- 执行buildHeap函数里的sink方法
index:1   leftChild:3   rightChild:4    present:3 更新后的arr:[8, 9, 5, 2, 7, 3]
index:3   leftChild:7   rightChild:8    present:3
构建堆过程中- 此次i循环以后的数组 arr:[8, 9, 5, 2, 7, 3]
 
开始构建堆- 执行buildHeap函数里的sink方法
index:0   leftChild:1   rightChild:2    present:1 更新后的arr:[9, 8, 5, 2, 7, 3]
index:1   leftChild:3   rightChild:4    present:1
构建堆过程中- 此次i循环以后的数组 arr:[9, 8, 5, 2, 7, 3]
 
成功构建堆以后的数组 arr:[9, 8, 5, 2, 7, 3]
 
数组长度 i = 5
元素下沉前的初始数组 arr:[9, 8, 5, 2, 7, 3]
开始执行 sort 函数里的sink方法
元素下沉前 堆顶堆尾互换后的数组 arr:[3, 8, 5, 2, 7, 9]
index:0   leftChild:1   rightChild:2    present:1 更新后的arr:[8, 3, 5, 2, 7, 9]
index:1   leftChild:3   rightChild:4    present:4 更新后的arr:[8, 7, 5, 2, 3, 9]
index:4   leftChild:9   rightChild:10    present:4此次i循环-元素下沉后的数组 arr:[8, 7, 5, 2, 3, 9]
 
数组长度 i = 4
元素下沉前的初始数组 arr:[8, 7, 5, 2, 3, 9]
开始执行 sort 函数里的sink方法
元素下沉前 堆顶堆尾互换后的数组 arr:[3, 7, 5, 2, 8, 9]
index:0   leftChild:1   rightChild:2    present:1 更新后的arr:[7, 3, 5, 2, 8, 9]
index:1   leftChild:3   rightChild:4    present:1此次i循环-元素下沉后的数组 arr:[7, 3, 5, 2, 8, 9]
 
数组长度 i = 3
元素下沉前的初始数组 arr:[7, 3, 5, 2, 8, 9]
开始执行 sort 函数里的sink方法
元素下沉前 堆顶堆尾互换后的数组 arr:[2, 3, 5, 7, 8, 9]
index:0   leftChild:1   rightChild:2    present:2 更新后的arr:[5, 3, 2, 7, 8, 9]
index:2   leftChild:5   rightChild:6    present:2此次i循环-元素下沉后的数组 arr:[5, 3, 2, 7, 8, 9]
 
数组长度 i = 2
元素下沉前的初始数组 arr:[5, 3, 2, 7, 8, 9]
开始执行 sort 函数里的sink方法
元素下沉前 堆顶堆尾互换后的数组 arr:[2, 3, 5, 7, 8, 9]
index:0   leftChild:1   rightChild:2    present:1 更新后的arr:[3, 2, 5, 7, 8, 9]
index:1   leftChild:3   rightChild:4    present:1此次i循环-元素下沉后的数组 arr:[3, 2, 5, 7, 8, 9]
 
数组长度 i = 1
元素下沉前的初始数组 arr:[3, 2, 5, 7, 8, 9]
开始执行 sort 函数里的sink方法
元素下沉前 堆顶堆尾互换后的数组 arr:[2, 3, 5, 7, 8, 9]
index:0   leftChild:1   rightChild:2    present:0此次i循环-元素下沉后的数组 arr:[2, 3, 5, 7, 8, 9]

[2, 3, 5, 7, 8, 9] 

*/