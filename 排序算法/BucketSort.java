
//桶排序  状态：还没完全弄懂

//桶排序可以看成是计数排序的升级版，它将要排的数据分到多个有序的桶里，每个桶里的数据再单独排序，再把每个桶的数据依次取出，即可完成排序。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
public class BucketSort {
// https://juejin.im/post/5cff49e75188257a6b40de80

    public static void sort(int[] arr) {
        // 最大最小值
        int max = arr[0];
        int min = arr[0];
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 最大值和最小值的差
        int diff = max - min;

        // 桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            bucketList.add(new ArrayList<>());
        }
        System.out.println( "桶列表-1: " + bucketList );

        // 每个桶的存数区间
        float section = (float) diff / (float) (length - 1);
        System.out.println("每个桶的存数区间: " + section);

        // 数据入桶
        for (int i = 0; i < length; i++) {
            // 当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;

            if (num < 0) {
                num = 0;
            }
            System.out.println("桶的下标: " + num);
            System.out.println("arr[i]: " + arr[i]);

            bucketList.get(num).add(arr[i]);
            System.out.println("桶列表-2: " + bucketList);
        }


        // 桶内排序
        for (int i = 0; i < bucketList.size(); i++) {
            // jdk的排序速度当然信得过
            Collections.sort(bucketList.get(i));
        }
        System.out.println("桶列表-3: " + bucketList);

        // 写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                arr[index] = value;
                index++;
            }
        }
    }


    public static void main(String[] args) {
        int[] data = new int[] { 500, 6123, 1700, 10, 9999 };
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}

*/


public class BucketSort {
// https://zhuanlan.zhihu.com/p/34168443

    // min的值为0，max的值为待排序数组中最大值+1
    public static void bucketSort(int[] data, int min, int max) {  
        // 缓存数组  
        int[] tmp = new int[data.length];  
        System.out.println("缓存数组: " + Arrays.toString(tmp));

        // buckets用于记录待排序元素的信息  
        // buckets数组定义了max-min个桶  
        int[] buckets = new int[max - min];  
        //System.out.println("buckets: " + Arrays.toString(buckets));

        // 计算每个元素在序列出现的次数  
        for (int i = 0; i < data.length; i++) {  
            buckets[data[i] - min]++;  
        }  
        //System.out.println("buckets: " + Arrays.toString(buckets));

        // 计算“落入”各桶内的元素在有序序列中的位置  
        for (int i = 1; i < max - min; i++) {  
            buckets[i] = buckets[i] + buckets[i - 1];  
        }  
        //System.out.println("buckets: " + Arrays.toString(buckets));

        // 将data中的元素完全复制到tmp数组中  
        System.arraycopy(data, 0, tmp, 0, data.length);  
        
        // 根据buckets数组中的信息将待排序列的各元素放入相应位置  
        for (int k = data.length - 1; k >= 0; k--) {  
            data[--buckets[tmp[k] - min]] = tmp[k];  
        }
        //System.out.println("data: " + Arrays.toString(data));  

    }


    public static void main(String[] args) {
        int[] data = new int[] { 500, 6123, 1700, 10, 9999 };
        bucketSort(data, 0, 10000);
        System.out.println(Arrays.toString(data));
    }


}