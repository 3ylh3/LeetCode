import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author yin_zhj
 * @date 2020/4/10
 */
public class LetterCombinationsofaPhoneNumber {
    /**
     * 递归思路，用一个hashmap来存储数组和对应字母字符串的映射关系，获取第一个数字对应的字母字符串，分别拼接上
     * 剩下的数字的递归结果
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<>();
        if(null == digits) {
            return rs;
        }
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if(digits.length() == 0) {
            return rs;
        }
        String number = digits.substring(0, 1);
        String lettersStr = map.get(number);
        for(int i = 0;i < lettersStr.length();i++) {
            List<String> list = letterCombinations(digits.substring(1));
            if(list.size() > 0) {
                for (String str : list) {
                    rs.add(lettersStr.substring(i, i + 1) + str);
                }
            } else {
                rs.add(lettersStr.substring(i, i + 1));
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber letterCombinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();
        List<String> list = letterCombinationsofaPhoneNumber.letterCombinations("23");
        for(String str : list) {
            System.out.println(str);
        }
    }
}
