package Leetcode;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class Vaild_Parentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()")); //true
        System.out.println(isValid("(")); //false
        System.out.println(isValid("()[]{}")); //true
        System.out.println(isValid("([]{})")); //true
        System.out.println(isValid("(]")); //false
        System.out.println(isValid("([)]")); //false
        System.out.println(isValid("({{{{}}}))")); //false
        System.out.println(isValid("[([]])")); //false
    }

    public static boolean isValid(String s) {
        if(s.startsWith(")") || s.startsWith("}") || s.startsWith("]")
                || s.endsWith("(") || s.endsWith("{") || s.endsWith("[")
                || s.length() % 2 != 0){
            return false;
        }
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
