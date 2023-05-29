package org.example.string_1;

public class Offer_1_58 {

    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();

        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
