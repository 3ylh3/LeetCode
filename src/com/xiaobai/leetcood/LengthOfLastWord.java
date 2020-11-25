package com.xiaobai.leetcood;

public class LengthOfLastWord {
    static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if(strings.length == 0){
            return 0;
        }
        else {
            return strings[strings.length - 1].length();
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("     "));
    }
}
