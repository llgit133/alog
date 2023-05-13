package easy;

public class BubbleSort {

    public static void function(int [] num){

        if(num == null || num.length <2){
            return;
        }

        // 0- n-1
        // 0- n-2
        for (int i = 0; i < num.length - 1; i++) {

            //  0 1 ,1 2 ,2 3 ,3 4,  n-1 n-2 比较
            for (int j = 0; j < num.length - i -1 ; j++) {
                if(num[j] > num[j+1]){
                    swapNum(num, j,j+1);
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

        int [] num = new int[]{ 8,5,7,2,1,0,6,3,9,4};
        PrintArray(num);
        function(num);
        PrintArray(num);


    }
}
