package easy;
public class EvenTimesOddTimes {

    // 1.出现奇数次的元素  用异或运算 满足结合律
    // 1 2 1 2 3 4 3 3 4 2 2 等同于下面
    // 异或 1 1 2 2 2 2 3 3 3 4 4     3只出现一次

    public static void function1(int [] nums){
        // eor 从头异或到尾
        int eor = 0;
        for (int num : nums) {
            eor = eor ^ num;
        }
        System.out.println(eor);
    }

    //2. 找2个出现奇数次
    // 1 1 2 2 2 4 4 5 5 5 6 6
    // 等价于：1 1 4 4 6 6 2 2 2 5 5 5    要求的是2，5

    public static void function2(int [] nums){
        // eor 从头异或到尾
        int eor = 0;
        for (int num : nums) {
            eor = eor ^ num;
        }
        // eor = a ^ b
        // eor 必然不为0， 则必有某一位异或的结果为1 ：分开 a b 其中一个   eor' = a or b
        // 再求出另一个

        // 1.eor = a ^ b
        // 2. onlyOne = a
        // 3. b  = eor ^ onlyOne
        // 则可求矣！！！

        int rightOne = eor & (~eor + 1);// 提取最右侧的1
        int onlyOne = 0;  // eor'
        for (int num : nums) {
            if((num & rightOne) ==0){
                onlyOne = onlyOne ^ num;
            }
        }
        System.out.println("第一个：" + onlyOne+"第二个：" + (eor ^ onlyOne));
    }


    public static void main(String[] args) {
        
        int [] nums1 = new int []{1, 2, 1, 2, 3, 4, 3, 3, 4, 2, 2};
        function1(nums1);  // 3

        //int [] nums2 = new int []{1, 1, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6};
        int [] nums2 = new int[]{1,2,10,4,1,4,3,3};
        function2(nums2);  //
    }

}
