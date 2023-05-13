package easy;

public class FactorialSum {

    public static int function(int num){

        int sum = 0;
        int res = 1;
        for (int i = 1; i <= num; i++) {

            res = res * i;
            sum = sum + res;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(function(4));
    }
}
