import java.util.Arrays;

//希尔排序（升级版的直接插入排序） ”缩小增量排序“（在直接插入排序的基础上加入缩小增量）

public class ShellSort {

    /* //添加了打印输出语句
    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment + "    ");
            for (int i = increment; i < data.length; i++) {
                System.out.print("i:" + i);
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                     System.out.print("  j:" + j);
                     System.out.print("  temp:" + temp);
                     System.out.println("  data[" + j + "]:" + data[j]);
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                    System.out.println("1: " + Arrays.toString(data));

                }
                System.out.println("2: " + Arrays.toString(data));

                data[j + increment] = temp;
                int x = j+increment;
                System.out.print("j: " + j);
                System.out.println("  j + increment: " + x);
                System.out.println("3: " + Arrays.toString(data));

            }

            //for (int i = 0; i < data.length; i++)
            //    System.out.print(data[i] + " ");
            //    System.out.println(" ");
                
        }
    }
    */

    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0; 
        for (int increment = data.length / 2; increment > 0; increment /= 2) { //如果数组有15个数，那么增量分别是：7 3 1
            for (int i = increment; i < data.length; i++) { //数组的第i个元素 靠右
                temp = data[i]; //关键一步：将第i个元素的值存入缓存，此后无论第i个元素如何变化，缓存/temp的值都是一开始第i个元素的值。如果第i个元素的值比第j个元素的值小（右边的比左边的小），那么就要互换。那时候缓存的值就能派上用场。
                for (j = i - increment; j >= 0; j -= increment) { //数组的第j个元素靠左，可能的起点（和i的大小差距为 增量
                                                                  // 的大小）：0，1，2，3，4...。然后j会递减直到最后一次降为负数。
                    if (temp < data[j]) { //如果右边的值比左边的小 如果temp改为 data[i]，打印输出结果不对
                        data[j + increment] = data[j]; //将第j个元素 赋值给 第 (j+增量) 个元素： 左边的值 赋值给 右边相距increment的位置
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp; // 将缓存的值(原先右边的值) 赋值给 左边原先第i个的位置（因为j的最后一个循环正好是：[i-增量]-增量 < 0 
                //因此这条语句的 j+increment=i-增量 也就是左边的位置。j退出循环时已经是负数了，加上increment 正好是靠左的正数）
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] { 12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2 };
        shellSortSmallToBig(data);
        System.out.println(Arrays.toString(data));
    }

}


/* 打印输出：
increment:7    
i:7  j:0  temp:13  data[0]:12
2: [12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2]
j: 0  j + increment: 7
3: [12, 9, 14, 6, 14, 3, 7, 13, 5, 11, 1, 10, 8, 4, 2]
i:8  j:1  temp:5  data[1]:9
1: [12, 9, 14, 6, 14, 3, 7, 13, 9, 11, 1, 10, 8, 4, 2]
2: [12, 9, 14, 6, 14, 3, 7, 13, 9, 11, 1, 10, 8, 4, 2]
j: -6  j + increment: 1
3: [12, 5, 14, 6, 14, 3, 7, 13, 9, 11, 1, 10, 8, 4, 2]
i:9  j:2  temp:11  data[2]:14
1: [12, 5, 14, 6, 14, 3, 7, 13, 9, 14, 1, 10, 8, 4, 2]
2: [12, 5, 14, 6, 14, 3, 7, 13, 9, 14, 1, 10, 8, 4, 2]
j: -5  j + increment: 2
3: [12, 5, 11, 6, 14, 3, 7, 13, 9, 14, 1, 10, 8, 4, 2]
i:10  j:3  temp:1  data[3]:6
1: [12, 5, 11, 6, 14, 3, 7, 13, 9, 14, 6, 10, 8, 4, 2]
2: [12, 5, 11, 6, 14, 3, 7, 13, 9, 14, 6, 10, 8, 4, 2]
j: -4  j + increment: 3
3: [12, 5, 11, 1, 14, 3, 7, 13, 9, 14, 6, 10, 8, 4, 2]
i:11  j:4  temp:10  data[4]:14
1: [12, 5, 11, 1, 14, 3, 7, 13, 9, 14, 6, 14, 8, 4, 2]
2: [12, 5, 11, 1, 14, 3, 7, 13, 9, 14, 6, 14, 8, 4, 2]
j: -3  j + increment: 4
3: [12, 5, 11, 1, 10, 3, 7, 13, 9, 14, 6, 14, 8, 4, 2]
i:12  j:5  temp:8  data[5]:3
2: [12, 5, 11, 1, 10, 3, 7, 13, 9, 14, 6, 14, 8, 4, 2]
j: 5  j + increment: 12
3: [12, 5, 11, 1, 10, 3, 7, 13, 9, 14, 6, 14, 8, 4, 2]
i:13  j:6  temp:4  data[6]:7
1: [12, 5, 11, 1, 10, 3, 7, 13, 9, 14, 6, 14, 8, 7, 2]
2: [12, 5, 11, 1, 10, 3, 7, 13, 9, 14, 6, 14, 8, 7, 2]
j: -1  j + increment: 6
3: [12, 5, 11, 1, 10, 3, 4, 13, 9, 14, 6, 14, 8, 7, 2]
i:14  j:7  temp:2  data[7]:13
1: [12, 5, 11, 1, 10, 3, 4, 13, 9, 14, 6, 14, 8, 7, 13]
  j:0  temp:2  data[0]:12
1: [12, 5, 11, 1, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
2: [12, 5, 11, 1, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
j: -7  j + increment: 0
3: [2, 5, 11, 1, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
increment:3    
i:3  j:0  temp:1  data[0]:2
1: [2, 5, 11, 2, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
2: [2, 5, 11, 2, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
j: -3  j + increment: 0
3: [1, 5, 11, 2, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
i:4  j:1  temp:10  data[1]:5
2: [1, 5, 11, 2, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
j: 1  j + increment: 4
3: [1, 5, 11, 2, 10, 3, 4, 12, 9, 14, 6, 14, 8, 7, 13]
i:5  j:2  temp:3  data[2]:11
1: [1, 5, 11, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
2: [1, 5, 11, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
j: -1  j + increment: 2
3: [1, 5, 3, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
i:6  j:3  temp:4  data[3]:2
2: [1, 5, 3, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
j: 3  j + increment: 6
3: [1, 5, 3, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
i:7  j:4  temp:12  data[4]:10
2: [1, 5, 3, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
j: 4  j + increment: 7
3: [1, 5, 3, 2, 10, 11, 4, 12, 9, 14, 6, 14, 8, 7, 13]
i:8  j:5  temp:9  data[5]:11
1: [1, 5, 3, 2, 10, 11, 4, 12, 11, 14, 6, 14, 8, 7, 13]
  j:2  temp:9  data[2]:3
2: [1, 5, 3, 2, 10, 11, 4, 12, 11, 14, 6, 14, 8, 7, 13]
j: 2  j + increment: 5
3: [1, 5, 3, 2, 10, 9, 4, 12, 11, 14, 6, 14, 8, 7, 13]
i:9  j:6  temp:14  data[6]:4
2: [1, 5, 3, 2, 10, 9, 4, 12, 11, 14, 6, 14, 8, 7, 13]
j: 6  j + increment: 9
3: [1, 5, 3, 2, 10, 9, 4, 12, 11, 14, 6, 14, 8, 7, 13]
i:10  j:7  temp:6  data[7]:12
1: [1, 5, 3, 2, 10, 9, 4, 12, 11, 14, 12, 14, 8, 7, 13]
  j:4  temp:6  data[4]:10
1: [1, 5, 3, 2, 10, 9, 4, 10, 11, 14, 12, 14, 8, 7, 13]
  j:1  temp:6  data[1]:5
2: [1, 5, 3, 2, 10, 9, 4, 10, 11, 14, 12, 14, 8, 7, 13]
j: 1  j + increment: 4
3: [1, 5, 3, 2, 6, 9, 4, 10, 11, 14, 12, 14, 8, 7, 13]
i:11  j:8  temp:14  data[8]:11
2: [1, 5, 3, 2, 6, 9, 4, 10, 11, 14, 12, 14, 8, 7, 13]
j: 8  j + increment: 11
3: [1, 5, 3, 2, 6, 9, 4, 10, 11, 14, 12, 14, 8, 7, 13]
i:12  j:9  temp:8  data[9]:14
1: [1, 5, 3, 2, 6, 9, 4, 10, 11, 14, 12, 14, 14, 7, 13]
  j:6  temp:8  data[6]:4
2: [1, 5, 3, 2, 6, 9, 4, 10, 11, 14, 12, 14, 14, 7, 13]
j: 6  j + increment: 9
3: [1, 5, 3, 2, 6, 9, 4, 10, 11, 8, 12, 14, 14, 7, 13]
i:13  j:10  temp:7  data[10]:12
1: [1, 5, 3, 2, 6, 9, 4, 10, 11, 8, 12, 14, 14, 12, 13]
  j:7  temp:7  data[7]:10
1: [1, 5, 3, 2, 6, 9, 4, 10, 11, 8, 10, 14, 14, 12, 13]
  j:4  temp:7  data[4]:6
2: [1, 5, 3, 2, 6, 9, 4, 10, 11, 8, 10, 14, 14, 12, 13]
j: 4  j + increment: 7
3: [1, 5, 3, 2, 6, 9, 4, 7, 11, 8, 10, 14, 14, 12, 13]
i:14  j:11  temp:13  data[11]:14
1: [1, 5, 3, 2, 6, 9, 4, 7, 11, 8, 10, 14, 14, 12, 14]
  j:8  temp:13  data[8]:11
2: [1, 5, 3, 2, 6, 9, 4, 7, 11, 8, 10, 14, 14, 12, 14]
j: 8  j + increment: 11
3: [1, 5, 3, 2, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
increment:1    
i:1  j:0  temp:5  data[0]:1
2: [1, 5, 3, 2, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
j: 0  j + increment: 1
3: [1, 5, 3, 2, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
i:2  j:1  temp:3  data[1]:5
1: [1, 5, 5, 2, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
  j:0  temp:3  data[0]:1
2: [1, 5, 5, 2, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
j: 0  j + increment: 1
3: [1, 3, 5, 2, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
i:3  j:2  temp:2  data[2]:5
1: [1, 3, 5, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
  j:1  temp:2  data[1]:3
1: [1, 3, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
  j:0  temp:2  data[0]:1
2: [1, 3, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
j: 0  j + increment: 1
3: [1, 2, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
i:4  j:3  temp:6  data[3]:5
2: [1, 2, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
j: 3  j + increment: 4
3: [1, 2, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
i:5  j:4  temp:9  data[4]:6
2: [1, 2, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
j: 4  j + increment: 5
3: [1, 2, 3, 5, 6, 9, 4, 7, 11, 8, 10, 13, 14, 12, 14]
i:6  j:5  temp:4  data[5]:9
1: [1, 2, 3, 5, 6, 9, 9, 7, 11, 8, 10, 13, 14, 12, 14]
  j:4  temp:4  data[4]:6
1: [1, 2, 3, 5, 6, 6, 9, 7, 11, 8, 10, 13, 14, 12, 14]
  j:3  temp:4  data[3]:5
1: [1, 2, 3, 5, 5, 6, 9, 7, 11, 8, 10, 13, 14, 12, 14]
  j:2  temp:4  data[2]:3
2: [1, 2, 3, 5, 5, 6, 9, 7, 11, 8, 10, 13, 14, 12, 14]
j: 2  j + increment: 3
3: [1, 2, 3, 4, 5, 6, 9, 7, 11, 8, 10, 13, 14, 12, 14]
i:7  j:6  temp:7  data[6]:9
1: [1, 2, 3, 4, 5, 6, 9, 9, 11, 8, 10, 13, 14, 12, 14]
  j:5  temp:7  data[5]:6
2: [1, 2, 3, 4, 5, 6, 9, 9, 11, 8, 10, 13, 14, 12, 14]
j: 5  j + increment: 6
3: [1, 2, 3, 4, 5, 6, 7, 9, 11, 8, 10, 13, 14, 12, 14]
i:8  j:7  temp:11  data[7]:9
2: [1, 2, 3, 4, 5, 6, 7, 9, 11, 8, 10, 13, 14, 12, 14]
j: 7  j + increment: 8
3: [1, 2, 3, 4, 5, 6, 7, 9, 11, 8, 10, 13, 14, 12, 14]
i:9  j:8  temp:8  data[8]:11
1: [1, 2, 3, 4, 5, 6, 7, 9, 11, 11, 10, 13, 14, 12, 14]
  j:7  temp:8  data[7]:9
1: [1, 2, 3, 4, 5, 6, 7, 9, 9, 11, 10, 13, 14, 12, 14]
  j:6  temp:8  data[6]:7
2: [1, 2, 3, 4, 5, 6, 7, 9, 9, 11, 10, 13, 14, 12, 14]
j: 6  j + increment: 7
3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10, 13, 14, 12, 14]
i:10  j:9  temp:10  data[9]:11
1: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 11, 13, 14, 12, 14]
  j:8  temp:10  data[8]:9
2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 11, 13, 14, 12, 14]
j: 8  j + increment: 9
3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12, 14]
i:11  j:10  temp:13  data[10]:11
2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12, 14]
j: 10  j + increment: 11
3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12, 14]
i:12  j:11  temp:14  data[11]:13
2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12, 14]
j: 11  j + increment: 12
3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12, 14]
i:13  j:12  temp:12  data[12]:14
1: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 14, 14]
  j:11  temp:12  data[11]:13
1: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 13, 14, 14]
  j:10  temp:12  data[10]:11
2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 13, 14, 14]
j: 10  j + increment: 11
3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]
i:14  j:13  temp:14  data[13]:14
2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]
j: 13  j + increment: 14
3: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14]

*/