package Math.random;

public class testRandom {

    public static void main(String[] args) {

        // [0.1) 返回
        double a = Math.random();

        // 等概率随机返回一个
        int testTimes = 1000000;
        int count1 = 0;
        for (int i = 0; i < testTimes; i++) {
            if( Math.random() < 0.75) count1++;
        }
        System.out.println((double) count1/(double) testTimes);


        System.out.println("===================");

        int count2 = 0;
        for (int i = 0; i < testTimes; i++) {
            if(Math.random() * 8 < 4) count2++;
        }
        System.out.println((double) count2/(double) testTimes);




    }
}
