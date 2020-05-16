// 1-10000 找出所有质数

public class TestPrimeNum {
    public static void main(String[] args) {
        boolean flag02 = true;
        long start02 = System.currentTimeMillis();

        for (int i = 2; i < 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag02 = false;
                    break; //对于当前数i，只要有一个j满足i % j == 0，即j是i的因数，就退出循环
                }
            }
            if (flag02 == true) {
                System.out.println(i);
            }
            flag02 = true;
        }

        long end02 = System.currentTimeMillis();
        System.out.println("经历的时间为：" + (end02 - start02));
    }
}


