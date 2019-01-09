import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters{
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