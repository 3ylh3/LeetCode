
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //辅助串，用于存储回文子串
        StringBuilder sb = new StringBuilder();
        //最大回文字串长度
        int max = 0;
        //最大回文字串
        String str = "";
        for(int i = 0;i< s.length();i++){
            for(int j = i;j < s.length();j++){
                sb.append(s.charAt(j));
                //判断辅助串是否为回文串
                if(sb.toString().equals(sb.reverse().toString())){
                    //判断辅助串长度和已存回文串长度
                    if(sb.length() > max){
                        max = sb.length();
                        str = sb.toString();
                    }
                }
                sb.reverse();
            }
            //清空辅助串
            sb.delete(0,sb.length());
        }
        return str;
    }

    public String longestPalindrome1(String s) {
        if(s.length() == 1){
            return s;
        }
        else {
            //最大回文字串长度
            int max = 0;
            //最大回文字串
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                //循环找以第i个字符开头的回文串
                //i和j分别用来记录回文串开始和结束位置，beg和end用来记录当前头和尾
                int beg = i;
                int j = s.length() - 1;
                //循环比较，当end>beg时代表比较完成
                for (int end = s.length() - 1; end > beg; ) {
                    //如果头和尾相等，则将beg指针后移，end指针前移，继续比较，并用j记录回文串尾部位置
                    if (s.charAt(beg) == s.charAt(end)) {
                        beg++;
                        end--;
                    }
                /*如果头和尾不等，则判断beg指针是否在头部，如果是，则让end指针前移，将j指针指向end;
                如果不是，则把beg指针移回头部，将j指针前移，end指针指向j，重新判断 */
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
