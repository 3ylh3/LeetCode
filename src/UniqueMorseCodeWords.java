import java.util.*;

public class UniqueMorseCodeWords {
    static int uniqueMorseRepresentations(String[] words) {
        Map map = new HashMap();
        map.put('a',".-");map.put('b',"-...");map.put('c',"-.-.");map.put('d',"-..");map.put('e',".");
        map.put('f',"..-.");map.put('g',"--.");map.put('h',"....");map.put('i',"..");map.put('j',".---");
        map.put('k',"-.-");map.put('l',".-..");map.put('m',"--");map.put('n',"-.");map.put('o',"---");
        map.put('p',".--.");map.put('q',"--.-");map.put('r',".-.");map.put('s',"...");map.put('t',"-");
        map.put('u',"..-");map.put('v',"...-");map.put('w',".--");map.put('x',"-..-");map.put('y',"-.--");
        map.put('z',"--..");
        Set<String> set = new HashSet();
        int num = 0;
        for(int i = 0;i < words.length;i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0;j < words[i].length();j++){
                sb.append(map.get(words[i].charAt(j)));
            }
            String s = new String(sb);
            if(!set.contains(s)){
                num++;
                set.add(s);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String[] words = {"cbrl","cdfl","wvtj","wvkm","anuyt"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
