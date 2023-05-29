package org.example.FirstPage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
public class algo_15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();


        return lists;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;
        int j = nums.length - 1;

        for (int k = 0; k < nums.length; k++) {
            int temp = nums[i]+nums[k]+nums[j];
            while (i < j){
                if(temp == 0){
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                }
                if(temp < 0){
                    i++;
                }
                else { j--; }
            }
            lists.add(list);
            list.clear();
        }
        return lists;
    }

    public static void main(String[] args) {

        int [] num = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum2(num);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "+ integer);
            }
        }


    }
}
