package com.xiaobai.leetcood;

/**
 * TODO
 *
 * @author yin_zhj
 * @date 2020/11/25
 */
public class LeetCode_984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        //记A和B为剩余需要写的a和b的个数
        while(A > 0 || B > 0) {
            int length = sb.length();
            if(length >= 2 && sb.charAt(length - 2) == sb.charAt(length - 1)) {
                //如果已经写了的个数大于等于2,并且最后两个字符连续，则应该换字符写
                if(sb.charAt(length - 2) == 'a') {
                    sb.append("b");
                    B--;
                } else{
                    sb.append("a");
                    A--;
                }
            } else {
                //如果最后两个字符不连续，则哪个剩余的多写哪个
                if(A > B) {
                    sb.append("a");
                    A--;
                } else {
                    sb.append("b");
                    B--;
                }
            }
        }
        return sb.toString();
    }
}
