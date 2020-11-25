package com.xiaobai.leetcood;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "z";
        String S = "ZZ";
        int count = 0;
        Set s = new HashSet();
        for(int i = 0;i < J.length();i++){
            s.add(J.charAt(i));
        }
        for(int i = 0;i < S.length();i++){
            if(s.contains(S.charAt(i))){
                count++;
            }
        }
        System.out.println(count);
    }
}
