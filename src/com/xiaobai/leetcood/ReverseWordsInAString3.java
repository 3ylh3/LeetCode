package com.xiaobai.leetcood;

public class ReverseWordsInAString3 {
    static String reverseWords(String s) {
        String[] rs = new String[100];
        String result = "";
        rs = s.split(" ");
        for(int i = 0;i < rs.length;i++){
            StringBuffer sb = new StringBuffer(rs[i]);
            sb.reverse();
            if(i != rs.length - 1) {
                result += sb + " ";
            }
            else{
                result += sb;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
