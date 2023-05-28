package Math.random;

public class testRandom {

    public static void main(String[] args) {

        // [0.1) 等概率返回一个
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


        // 生成范围上的随机数
        int k = 9;
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了： "+counts[i]);
        }

        // 把数字出现的概率  0-1 线性 变成0-x^2 曲线
        double x = 0.2;

    }

    // 把数字出现的概率  0-1 线性 变成0-x^2 曲线

    public static double xToXPower(){
        // 第一次落在 0-X 上
        // 第二次也落在 0-x 上
        return Math.max(Math.random(), Math.random());
    }

}
