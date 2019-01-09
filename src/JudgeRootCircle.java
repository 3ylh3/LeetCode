class Solution1 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(int i = 0;i < moves.length();i++){
            switch (moves.charAt(i)){
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        if(x == 0 & y == 0)
            return true;
        else
            return false;
    }
}
public class JudgeRootCircle {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.judgeCircle("UD"));
    }
}
