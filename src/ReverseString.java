import java.util.Stack;

public class ReverseString {
    static String reverseString(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.reverse();
        return String.valueOf(stringBuffer);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }
}
