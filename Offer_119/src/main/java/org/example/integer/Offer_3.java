package org.example.integer;

public class Offer_3 {

    public static int[] countBits(int n) {
        int [] res = new int[n+1];

        for (int i = 0; i < res.length; i++) {}

        StringBuilder[] str = getString(res);

        for (int i = 0; i < str.length; i++) {
            int count = 0;
            StringBuilder temp = str[i];
            for (int j = 0; j < temp.length() ; j++) {
                if(temp.charAt(j) == '1') count++;
            }
            res[i] = count;
        }
        return res;
    }

    public static StringBuilder[] getString(int[] res){

        // 对0、1、2、3、4、5 求二进制位
        StringBuilder[] str = new StringBuilder[res.length];
        for (int i = 0; i < res.length; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 31; j >= 0; j--) {
                String s = (i & (1 << j)) == 0 ? "0" : "1";
                t.append(s);
            }
            str[i] = t;
        }
        return str;
    }

    public static void main(String[] args) {

        int[] ints = countBits(2);
        for (int anInt : ints) {
            System.out.print("" + anInt);
        }
    }
}
