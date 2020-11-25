package com.xiaobai.leetcood;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的?最长子串?的长度。
 *
 * 示例?1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
 * ?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters{
    /**
     * 用一个字符队列来存储临时的非重复字符串，遍历数组，如果队列中已经存在当前字符，则说明重复，将队列第一个元素
     * 出队列，重新比较；如果不存在则将当前字符入队列，继续遍历下一个字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //辅助队列，用于存储非重复字串
        Queue<Character> queue = new LinkedList<Character>();
        //最大非重复字串长度
        int max = 0;
        for(int i = 0;i < s.length();){
            //如果辅助队列为空，则把当前字符入队列
            if(queue.isEmpty()){
                queue.add(s.charAt(i));
                i++;
            }
            else{
                //如果辅助队列中已有当前字符，说明重复，则将队列第一个元素出队列，重新比较
                if(queue.contains(s.charAt(i))){
                    queue.poll();
                }
                else{
                    //如果辅助队列中没有当前字符，则将当前字符入队列
                    queue.add(s.charAt(i));
                    i++;
                }
            }
            if(queue.size() > max){
                max = queue.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
    }
}