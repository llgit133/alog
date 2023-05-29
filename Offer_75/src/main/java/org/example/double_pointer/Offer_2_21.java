package org.example.double_pointer;

public class Offer_2_21 {
    public static int[] exchange(int[] nums) {
        int [] res = new int[nums.length];
        int index = 0;

        // 先放奇数、再放偶数
        for (int num : nums) {
            if(num % 2 != 0) res[index++] = num;
        }

        for (int num : nums) {
            if(num % 2 == 0) res[index++] = num;
        }
        return res;
    }
    public static void main(String[] args) {

        int [] nums =new int[]{1,2,3,4};
        int[] ints = exchange(nums);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
