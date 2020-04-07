/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行?Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"?行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int i = 0;
        int j = 0;
        int row = numRows;
        int col = s.length();
        boolean flag = true;
        char[][] temp = new char[numRows][col];
        for(int p = 0;p < row;p++){
            for(int q = 0;q < col;q++){
                temp[p][q] = ' ';
            }
        }
        for(int cout = 0;cout < s.length();cout++){
            temp[i][j] = s.charAt(cout);
            if(flag){
                if(i < numRows - 1){
                    i++;
                }
                else{
                    j++;
                    i--;
                    flag = false;
                }
            }
            else{
                if(i != 0){
                    j++;
                    i--;
                }
                else{
                    i++;
                    flag = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p = 0;p < row;p++){
            for(int q = 0;q < col;q++){
                if(temp[p][q] != ' '){
                    sb.append(temp[p][q]);
                }
            }
        }
        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        //用numRows个stringbuilder来表示每一行的字符
        StringBuilder[] sbs = new StringBuilder[numRows];
        //初始化数组
        for(int i = 0;i < numRows;i++){
            sbs[i] = new StringBuilder();
        }
        int j = 0;
        //flag表示j指针是正向移动还是反向移动
        boolean flag = true;
        StringBuilder temp = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            sbs[j].append(s.charAt(i));
            if(flag){
                if(j < numRows - 1){
                    j++;
                }
                else{
                    j--;
                    flag = false;
                }
            }
            else{
                if(j == 0){
                    flag = true;
                    j++;
                }
                else{
                    j--;
                }
            }
        }
        for(int i = 0;i < numRows;i++){
            temp.append(sbs[i].toString());
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion a = new ZigZagConversion();
        System.out.println(a.convert1("LEETCODEISHIRING",3));
    }
}
