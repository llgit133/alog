package easy;

public class InsertSort {

    public static void function(int[] num){

        if(num == null || num.length <2){
            return;
        }

        // 比较 + 交换
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0; j--) {
                if( num[j-1] > num[j]){
                    swapNum(num,j,j-1 );
                }
            }
        }
    }


    public static void swapNum(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static  void PrintArray(int [] arr){
        for (int i : arr) {
            System.out.print(" "+ i);
        }
        System.out.println();

    }


    public static void main(String[] args) {

        int[] nums = new int []{8,5,7,2,1,0,6,3,9,4};
        PrintArray(nums);
        function(nums);
        PrintArray(nums);

    }
}
