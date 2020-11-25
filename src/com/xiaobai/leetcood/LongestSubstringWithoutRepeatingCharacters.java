package com.xiaobai.leetcood;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ���?��Ӵ�?�ĳ��ȡ�
 *
 * ʾ��?1:
 *
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 *
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 *
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
 * ?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
 */
public class LongestSubstringWithoutRepeatingCharacters{
    /**
     * ��һ���ַ��������洢��ʱ�ķ��ظ��ַ������������飬����������Ѿ����ڵ�ǰ�ַ�����˵���ظ��������е�һ��Ԫ��
     * �����У����±Ƚϣ�����������򽫵�ǰ�ַ�����У�����������һ���ַ�
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //�������У����ڴ洢���ظ��ִ�
        Queue<Character> queue = new LinkedList<Character>();
        //�����ظ��ִ�����
        int max = 0;
        for(int i = 0;i < s.length();){
            //�����������Ϊ�գ���ѵ�ǰ�ַ������
            if(queue.isEmpty()){
                queue.add(s.charAt(i));
                i++;
            }
            else{
                //����������������е�ǰ�ַ���˵���ظ����򽫶��е�һ��Ԫ�س����У����±Ƚ�
                if(queue.contains(s.charAt(i))){
                    queue.poll();
                }
                else{
                    //�������������û�е�ǰ�ַ����򽫵�ǰ�ַ������
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