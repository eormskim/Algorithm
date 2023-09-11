package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * 1 <= n <= 8
 */
public class Generate_Parentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3)); //["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(generateParenthesis(1)); //["()"]
        System.out.println(generateParenthesis(8));
    }

    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }


    private static void generateParenthesisHelper(List<String> result, String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            generateParenthesisHelper(result, current + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            generateParenthesisHelper(result, current + ")", openCount, closeCount + 1, n);
        }
    }
}
