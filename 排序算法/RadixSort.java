
//基数排序  可以看成桶排序的扩展，也是用桶来辅助排序

/*
基数排序是一种非比较型整数排序算法，其原理是将数据按位数切割成不同的数字，然后按每个位数分别比较。
假设说，我们要对 100 万个手机号码进行排序，应该选择什么排序算法呢？排的快的有归并、快排时间复杂度是 O(nlogn)，计数排序和桶排序虽然更快一些，但是手机号码位数是11位，那得需要多少桶？内存条表示不服。
这个时候，我们使用基数排序是最好的选择。
链接：https://juejin.im/post/5cff49e75188257a6b40de80
*/

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] arr){
        int length = arr.length;

        //找到数组里的最大值
        int max = arr[0];
        for(int i = 0;i < length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //当前排序位置
        int location = 1; //location：位数（个位数：location=1，十位数：location=2，百位数：location=3）

        //桶列表
        ArrayList<  ArrayList<Integer> > bucketList = new ArrayList<> (); //桶列表是一个由很多桶组成的大数组，里面有一个个桶，每个桶实质上是一个数组

        //长度为10 装入余数0-9的数据
        for(int i = 0; i < 10; i++){
            bucketList.add(new ArrayList<Integer> ()); //一共10个i循环，每次循环都会往bucketList里添加一个空的数组（整数型），因此一共10个数组，从左到右分别代表余数0-9
        }
        //System.out.println("bucketList-0: " + bucketList);

        while(true){
            //判断是否排完
            int dd = (int)Math.pow(10, (location - 1)); //dd的作用是帮助我们分别比较每个数的个位数(d=1)，十位数(d=10)，百位数(d=100)，千位数(d=1000)... 
            if(max < dd){ //如果max=9999，只要dd=10000，就说明我们已经根据个位数，十位数，百位数，千位数，万位数的排序，不需要再在此while循环里执行剩余语句了。
                break;
            }
            //System.out.print("  location: " + location);
            //System.out.print("  dd: " + dd);

            //将数据写入桶用于排序
            for(int i = 0; i < length; i++){
                //计算余数 放入相应的桶
                int number = ((arr[i] / dd) % 10); // 计算出来的number代表桶的id，如果number=1，代表将数据放入第二个（id=1）桶里面

                //System.out.print("    arr[i]: " + arr[i]);
                //System.out.println("    number: " + number);

                bucketList.get(number).add(arr[i]); //先通过get(number)确定桶号，然后再通过add(arr[i]将此次循环的数组元素arr[i]放入该桶中
            }
            //System.out.println("    bucketList-1: " + bucketList);

            //将桶内的数据写回数组
            int nn = 0;
            for (int i=0;i<10;i++){ //第一层循环i:对于每一个余数：（0-9），也就是每一个桶
                int size = bucketList.get(i).size(); //size：桶列表中当前桶中的元素个数

                for(int ii = 0;ii < size;ii ++){ //第二层循环ii：对于当前桶中的某一个元素
                    arr[nn++] = bucketList.get(i).get(ii); // get(i)获得当前桶 get(ii)获得当前桶内的当前元素
                }
                //截止到这，我们已经完成了针对于某一位数的一次排序，接下来我们会清空桶列表用于下一个位数的排序。
                bucketList.get(i).clear(); // 清空桶列表用于下一个位数的排序
            }
            //System.out.println("    bucketList-2: " + bucketList);

            location++; //location：位数（个位数：location=1，十位数：location=2，百位数：location=3）
        }

    }

    public static void main(String[] args) {
        int[] data = new int[] { 892, 846, 821, 199, 810, 700 };
        sort(data);
        //System.out.println(Arrays.toString(data));
    }
    
}


/* 打印输出：

bucketList-0: [[], [], [], [], [], [], [], [], [], []]
  location: 1  dd: 1    arr[i]: 892    number: 2
    arr[i]: 846    number: 6
    arr[i]: 821    number: 1
    arr[i]: 199    number: 9
    arr[i]: 810    number: 0
    arr[i]: 700    number: 0
    bucketList-1: [[810, 700], [821], [892], [], [], [], [846], [], [], [199]]
    bucketList-2: [[], [], [], [], [], [], [], [], [], []]
  location: 2  dd: 10    arr[i]: 810    number: 1
    arr[i]: 700    number: 0
    arr[i]: 821    number: 2
    arr[i]: 892    number: 9
    arr[i]: 846    number: 4
    arr[i]: 199    number: 9
    bucketList-1: [[700], [810], [821], [], [846], [], [], [], [], [892, 199]]
    bucketList-2: [[], [], [], [], [], [], [], [], [], []]
  location: 3  dd: 100    arr[i]: 700    number: 7
    arr[i]: 810    number: 8
    arr[i]: 821    number: 8
    arr[i]: 846    number: 8
    arr[i]: 892    number: 8
    arr[i]: 199    number: 1
    bucketList-1: [[], [199], [], [], [], [], [], [700], [810, 821, 846, 892], []]
    bucketList-2: [[], [], [], [], [], [], [], [], [], []]
[199, 700, 810, 821, 846, 892]

*/

