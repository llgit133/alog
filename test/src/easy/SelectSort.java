package easy;

public class SelectSort {

    public static void function(int [] num){
        if(num == null || num.length < 2){
            return ;
        }

        int N = num.length;
        // 0-N 1-N  2-N
        for (int i = 0; i < N ; i++) {
            // 找到最小值下标
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = num[j] < num[minValueIndex] ? j : minValueIndex;
            }
            swapNum(num, i, minValueIndex);
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
