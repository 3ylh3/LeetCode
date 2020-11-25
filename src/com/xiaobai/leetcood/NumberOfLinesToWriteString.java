package com.xiaobai.leetcood;

import java.util.HashMap;
import java.util.Map;

public class NumberOfLinesToWriteString {
    static int[] numberOfLines(int[] widths, String S) {
        int[] result = {1,0};
        int r = 0;
        Map map = new HashMap();
        map.put('a',widths[0]);map.put('b',widths[1]);map.put('c',widths[2]);map.put('d',widths[3]);map.put('e',widths[4]);
        map.put('f',widths[5]);map.put('g',widths[6]);map.put('h',widths[7]);map.put('i',widths[8]);map.put('j',widths[9]);
        map.put('k',widths[10]);map.put('l',widths[11]);map.put('m',widths[12]);map.put('n',widths[13]);map.put('o',widths[14]);
        map.put('p',widths[15]);map.put('q',widths[16]);map.put('r',widths[17]);map.put('s',widths[18]);map.put('t',widths[19]);
        map.put('u',widths[20]);map.put('v',widths[21]);map.put('w',widths[22]);map.put('x',widths[23]);map.put('y',widths[24]);
        map.put('z',widths[25]);
        for(int i = 0;i < S.length();i++){
            r += (int)map.get(S.charAt(i));
            if(r > 100){
                result[0]++;
                r = (int)map.get(S.charAt(i));
            }
        }
        result[1] = r;
        return result;
    }

    public static void main(String[] args) {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] r = numberOfLines(widths,"bbbcccdddaaa");
        System.out.println(r[0] + " " + r[1]);
    }
}
