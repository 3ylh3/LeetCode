
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //�����������ڴ洢�����Ӵ�
        StringBuilder sb = new StringBuilder();
        //�������ִ�����
        int max = 0;
        //�������ִ�
        String str = "";
        for(int i = 0;i< s.length();i++){
            for(int j = i;j < s.length();j++){
                sb.append(s.charAt(j));
                //�жϸ������Ƿ�Ϊ���Ĵ�
                if(sb.toString().equals(sb.reverse().toString())){
                    //�жϸ��������Ⱥ��Ѵ���Ĵ�����
                    if(sb.length() > max){
                        max = sb.length();
                        str = sb.toString();
                    }
                }
                sb.reverse();
            }
            //��ո�����
            sb.delete(0,sb.length());
        }
        return str;
    }

    public String longestPalindrome1(String s) {
        if(s.length() == 1){
            return s;
        }
        else {
            //�������ִ�����
            int max = 0;
            //�������ִ�
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                //ѭ�����Ե�i���ַ���ͷ�Ļ��Ĵ�
                //i��j�ֱ�������¼���Ĵ���ʼ�ͽ���λ�ã�beg��end������¼��ǰͷ��β
                int beg = i;
                int j = s.length() - 1;
                //ѭ���Ƚϣ���end>begʱ����Ƚ����
                for (int end = s.length() - 1; end > beg; ) {
                    //���ͷ��β��ȣ���begָ����ƣ�endָ��ǰ�ƣ������Ƚϣ�����j��¼���Ĵ�β��λ��
                    if (s.charAt(beg) == s.charAt(end)) {
                        beg++;
                        end--;
                    }
                /*���ͷ��β���ȣ����ж�begָ���Ƿ���ͷ��������ǣ�����endָ��ǰ�ƣ���jָ��ָ��end;
                ������ǣ����begָ���ƻ�ͷ������jָ��ǰ�ƣ�endָ��ָ��j�������ж� */
                    else {
                        if (beg != i) {
                            beg = i;
                            end = j - 1;
                            j = end;
                        } else {
                            end--;
                            j = end;
                        }
                    }
                }
                if (j - i + 1 > max) {
                    str = s.substring(i, j + 1);
                    max = str.length();
                }
            }
            return str;
        }
    }

    public static void main(String[] args) {
        LongestPalindrome a = new LongestPalindrome();
        System.out.println(a.longestPalindrome1("aaabaaaa"));
    }
}
