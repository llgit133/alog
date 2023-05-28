package easy;

public class BitaSwap {


    // 位运算，先转换为2进制表示，运算完后，再转回10进制：
    // 满足交换律，结合律
    // 1. 异或运算 (相同为0， 不同为1)：  也可看成无进位相加

    // a b 数据交换
    public static void SwapNum(int a, int b){
         a = a ^ b ;   // a = 甲 ^ 乙   b = 乙
         b = a ^ b;    // b = 甲 ^ 乙 ^ 乙  = 甲 ^ 0 = 甲
         a = a ^ b;    // a = 甲 ^ 乙 ^ 甲  = 乙 ^ 甲 ^ 甲 =乙
        System.out.printf("%d, %d", a, b);
    }
    public static void main(String[] args) {

        SwapNum(12,10);
    }

}
