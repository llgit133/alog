package org.example.string_1;

public class Offer_1_05 {

    public static String replaceSpace(String s) {

        //    StringBuilder sb = new StringBuilder();
        //     for(int i = 0;i<s.length();i++){

        //         if(s.charAt(i) == ' ') {
        //             sb.append("%20");
        //         }
        //         else{
        //             sb.append(s.charAt(i));
        //         }
        //     }
        //     return sb.toString();
        // }

        String[] arr = s.split("\\s", -1);
        //String.join 可以在字符数组的间隙添加
        return String.join("%20", arr);

    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
