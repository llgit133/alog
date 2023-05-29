package org.example.double_pointer;

import java.util.Stack;

public class Offer_2_58 {
    public static String reverseWords(String s) {

        s = s.trim();
        String[] myArray = s.split("\\s+");
        String str = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < myArray.length; i++) {
            stack.push(myArray[i]);
        }
        while(!stack.empty() ){
            str += " "+stack.pop();
        }
        return str.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("    the sky is    blue"));
    }
}
