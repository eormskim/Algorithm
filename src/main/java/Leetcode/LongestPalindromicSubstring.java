package Leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        System.out.println(longestPalindrome("babad") + "*********************"); //bab
        System.out.println(longestPalindrome("cbbd") + "*********************"); //bb
        System.out.println(longestPalindrome("ac") + "*********************"); //a
        System.out.println(longestPalindrome("bb") + "*********************"); //bb
        System.out.println(longestPalindrome("ccc") + "*********************"); //ccc
        System.out.println(longestPalindrome("abcba") + "*********************"); //abcba
        System.out.println(longestPalindrome("aacabdkacaa") + "*********************"); //aca
        System.out.println(longestPalindrome("bacabab") + "*********************"); //bacab
    }

    public static String longestPalindrome(String s) {
        String rtnVal = "";
        String str = s;
        for(int i=0; i<s.length(); i++){
            String reqPalStr = palindromeStr(str);
            if(!reqPalStr.equals("") && reqPalStr.length() > rtnVal.length()) {
                rtnVal = reqPalStr;
            }
            if(rtnVal.length() >= str.length()){
                break;
            }
            str = str.substring(1);
        }
        return rtnVal;
    }
    public static String palindromeStr(String s) {
        boolean isPal = true;
        String str = s;
        for(int i=0; i<str.length();){
            if(str.charAt(i) != str.charAt(str.length()-(i == 0 ? 1 : i+1)) && i != str.length()/2.0 + 0.5){
                isPal = false;
                i=0;
                str = str.substring(0, str.length()-1);
                continue;
            }else{
                isPal = true;
            }
            i++;
        }
        if(!isPal){
            str = "";
        }
        return str;
    }

}
