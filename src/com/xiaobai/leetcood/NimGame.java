package com.xiaobai.leetcood;

public class NimGame {
    static boolean canWinNim(int n) {
        if (n <= 3)
            return true;
        else if(n == 4)
            return false;
        else if(n%4 == 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(5));
    }
}
