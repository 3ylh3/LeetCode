import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class SelfDividingNumbers {
    static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<Integer>();

        for(;left <= right;left++){
            Boolean flag = true;
            String s = String.valueOf(left);
            for(int i = 0;i < s.length();i++){
                if(s.charAt(i) == '0'){
                    flag = false;
                    break;
                }
                if(left % Integer.parseInt(String.valueOf(s.charAt(i))) != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(1,22);
        for(Iterator i = list.iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }
}
