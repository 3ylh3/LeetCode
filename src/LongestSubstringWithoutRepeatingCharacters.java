import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters{
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