import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author yin_zhj
 * @date 2020/4/11
 */
public class ValidParentheses {
    /**
     * 使用一个栈，遍历字符串，如果栈为空，则将当前字符入栈，如果栈非空，则判断栈顶字符是否为（、[或者{，如果不是则
     * 字符串不合法，如果是，则判断是否和当前字符匹配，如果匹配则出栈，如果不匹配则入栈，如果遍历完后栈为空则合法，
     * 否则不合法
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(null == s || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char c = stack.peek();
                if (c == '(') {
                    if (s.charAt(i) == ')') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else if (c == '[') {
                    if (s.charAt(i) == ']') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else if(c == '{') {
                    if (s.charAt(i) == '}') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([)]"));
    }
}
