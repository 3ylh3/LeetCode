import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author yin_zhj
 * @date 2020/4/14
 */
public class LongestValidParentheses {
    /**
     * 超时。。。
     * @param s
     * @return
     */
//    public int longestValidParentheses(String s) {
//        if(null == s || s.length() == 0) {
//            return 0;
//        }
//        int max = 0;
//        for(int i = 0;i < s.length();i++) {
//
//            if(')' == s.charAt(i)) {
//                continue;
//            }
//            Stack<Character> stack = new Stack<>();
//            stack.push(s.charAt(i));
//            for(int j = i + 1;j < s.length();j++) {
//                if('(' == s.charAt(j)) {
//                    stack.push(s.charAt(j));
//                } else {
//                    if(!stack.isEmpty()) {
//                        stack.pop();
//                        if (stack.isEmpty()) {
//                            max = Math.max(max, j - i + 1);
//                        }
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        return max;
//    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
    }
}
