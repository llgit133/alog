package easy;

public class Print32bit {



    // 左移 然后再&操作
    public static void Print_Int(int num) {
        for (int i = 31; i >= 0; i--) {
            String s = (num & (1 << i)) == 0 ? "0" : "1";
            System.out.print(s);
        }
        System.out.println();
    }
    public static void main(String[] args) {



        Print_Int(12);
        Print_Int(1);
//        Print_Int(2);
//        Print_Int(1 | 2);
//        Print_Int(1 & 2);
//        Print_Int(1 ^ 2);
//        Print_Int(-1);


//        int b = 1324871;
//        int c = ~b;
//        Print_Int(b);
//        Print_Int(c);
//        Print_Int(-5);

        //-32768
//        Print_Int(Integer.MIN_VALUE);
//        Print_Int(Integer.MAX_VALUE);

        // 负数补码的右移
//        int d = Integer.MIN_VALUE;
//        Print_Int(d);
//        Print_Int(d >> 1); // 带符号右移动
//        Print_Int(d >>> 1); // 不带符号右移


//        int e = 5;
//        int f = -5;
//        f = ~ e + 1 ; // 取反再加1
//        System.out.println(e);
//        System.out.println(f);


        // 理解 负数就是取反再加1
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(~Integer.MIN_VALUE + 1);
//        System.out.println(-Integer.MIN_VALUE);
    }
}
