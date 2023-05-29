package org.example.double_pointer;

public class Offer_2_57 {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum < target) i++;
            else if(sum > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }
    }
}
