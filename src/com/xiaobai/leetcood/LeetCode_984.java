package com.xiaobai.leetcood;

/**
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 *
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 *  
 *
 * 示例 1：
 *
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 示例 2：
 *
 * 输入：A = 4, B = 1
 * 输出："aabaa"
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

    public static void main(String[] args) {
        LeetCode_984 a = new LeetCode_984();
        System.out.println(a.strWithout3a3b(5, 1));
    }
}
