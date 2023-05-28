package org.example.easy;

public class binarySearch {


    // 返回查找数字的下标
    public static int function(int [] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = (low + high)/2;
            if( nums[mid] > target) {high = mid - 1;}
            if( nums[mid] < target) {low = mid + 1;}
            else {return mid;}
        }

        return -1;
    }

    //升级，找>= 3 最左侧、最右侧的数字    二分法
    public static int function1(int [] nums, int target){

        int low = 0;
        int high = nums.length - 1;


        return -1;
    }

    // 无序的二分问题  局部最小（必有）
    public static int function2(int [] nums, int target){

        int low = 0;
        int high = nums.length - 1;


        return -1;
    }
    public static void main(String[] args) {
        int [] nums = new int []{1,2,3,4,5,6,7,8,9};
        System.out.println(function(nums, 9));
    }
}
