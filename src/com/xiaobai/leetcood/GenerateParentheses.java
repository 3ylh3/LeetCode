package com.xiaobai.leetcood;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * @author yin_zhj
 * @date 2020/4/9
 */
public class GenerateParentheses {
    /**
     * 第一个括号可能什么都不括住，也可能括住1、2、3....n-1对括号，对两种情况进行递归，第一种情况在递归后的结果集中的
     * 每个字符串前加一个括号，第二种情况需要递归两次，分别得到i（i从1到n - 1）个括号和n - i - 1个括号的结果集，然后
     * 在i个括号的结果集中每个字符串两侧拼上左括号和右括号，再拼上n - i - 1的结果集中的没种情况，就得到了所有的情况
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) {
            list.add("");
            return list;
        }
        if(n == 1) {
            list.add("()");
            return list;
        }
        List<String> rs1 = generateParenthesis(n - 1);
        for(String s : rs1) {
            //第一个括号什么都不括住的情况
            list.add("()" + s);
        }
        for(int i = 1;i < n;i++) {
            List<String> rs3 = generateParenthesis(i);
            List<String> rs4 = generateParenthesis(n - i - 1);
            for(String s1 : rs3) {
                for(String s2 : rs4) {
                    //第一个括号括住i个括号的情况
                    list.add("(" + s1 + ")" + s2);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> list = generateParentheses.generateParenthesis(3);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
