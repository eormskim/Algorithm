package Leetcode;
/** Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).*/
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));//false
        System.out.println(isMatch("aa","a*"));//true
        System.out.println(isMatch("ab",".*"));//true
    }

    static boolean isMatch(String s, String p){
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
