package Leetcode;

import java.math.BigInteger;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class StringtoInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi(" +-"));
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi("   +0 123"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("-abc"));
    }

    static int myAtoi(String s){
        s = s.trim();
        if(s.isEmpty() || s.equals("+") || s.equals("-")){
            return 0;
        }
        boolean isNegativeNumber = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            String str = Character.toString(s.charAt(i));
            if(sb.length() > 0 && (str.equals(" ") || str.equals("-") || str.equals("+"))){
                if(sb.toString().endsWith("+") || sb.toString().endsWith("-")){
                    return 0;
                }
                return checkValue(isNegativeNumber, sb);
            }
            switch (str){
                case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "+":
                    sb.append(s.charAt(i));
                    break;
                case "-":
                    isNegativeNumber = true; //음수 체크
                    sb.append(s.charAt(i));
                    break;
                default:
                    if(sb.toString().equals("+") || sb.toString().equals("-")){
                        return 0;
                    }
                    if(sb.length() > 0){
                        return checkValue(isNegativeNumber, sb);
                    }else{
                        return 0;
                    }
            }
        }
        return checkValue(isNegativeNumber, sb);
    }

    private static int checkValue(boolean isNegativeNumber, StringBuilder sb) {
        BigInteger rtnVal = new BigInteger(sb.toString());

        if(isNegativeNumber){
            if(rtnVal.compareTo(BigInteger.valueOf((Integer.MIN_VALUE))) < 0){ //최소값 넘으면 최소값 반환
                return Integer.MIN_VALUE;
            }
            rtnVal.multiply(BigInteger.valueOf(-1));
        }else{
            if(rtnVal.compareTo(BigInteger.valueOf((Integer.MAX_VALUE))) > 0){ //최대값 넘으면 최대값 반환
                return Integer.MAX_VALUE;
            }
        }
        return rtnVal.intValue();
    }
}
