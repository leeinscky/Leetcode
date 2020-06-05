import java.util.*;

public class ListTest {
    public static void main(String[] args){
        List<Integer> testList = new ArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.remove(4);
        
        testList.set(3, 100);//set(int index, E element) 在索引为index位置的元素更改为element元素
        testList.add(0, 99);//add(int index, E element) 在指定位置插入元素，后面的元素都往后移一个元素。

        for (int item: testList){
            System.out.println(item);
        }

        System.out.println(testList.get(3));

    }
}