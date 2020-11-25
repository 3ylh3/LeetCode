package com.xiaobai.leetcood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class KeyboardRow {
    static String[] findWords(String[] words) {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        Set s3 = new HashSet();
        String[] r = new String[words.length];
        ArrayList<String> r1 = new ArrayList<>();
        s1.add('q');s1.add('w');s1.add('e');s1.add('r');s1.add('t');s1.add('y');s1.add('u');s1.add('i');s1.add('o');s1.add('p');
        s2.add('a');s2.add('s');s2.add('d');s2.add('f');s2.add('g');s2.add('h');s2.add('j');s2.add('k');s2.add('l');
        s3.add('z');s3.add('x');s3.add('c');s3.add('v');s3.add('b');s3.add('n');s3.add('m');
        for(int i = 0;i < words.length;i++){
            r[i] = words[i].toLowerCase();
        }
        for(int i = 0;i < r.length;i++){
            Boolean flag1 = true;
            Boolean flag2 = true;
            Boolean flag3 = true;
            for(int k = 0;k < r[i].length();k++){
                if(!s1.contains(r[i].charAt(k))){
                    flag1 = false;
                }
                if(!s2.contains(r[i].charAt(k))){
                    flag2 = false;
                }
                if(!s3.contains(r[i].charAt(k))){
                    flag3 = false;
                }
            }
            if(flag1 == true || flag2 == true || flag3 == true){
                r1.add(words[i]);
            }
        }
        String[] result = new String[r1.size()];
        for(int i = 0;i < result.length;i++){
            result[i] = r1.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        String[] rs = findWords(s);
        for(int i = 0;i < rs.length;i++){
            System.out.println(rs[i]);
        }
    }
}
