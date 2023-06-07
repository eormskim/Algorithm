package Leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"})); //"fl"
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"})); //""
        System.out.println(longestCommonPrefix(new String[]{""})); //""
        System.out.println(longestCommonPrefix(new String[]{"ab","a"})); //""
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"})); //""
    }

    static String longestCommonPrefix(String[] strs){
        int strSize = strs[0].length();
        for(int i=1; i<strs.length; i++){
            if(strSize > strs[i].length()){ //문자열 크기가 비교할 문자열보다 크면 비교할 문자열 사이즈로 변경
                strSize = strs[i].length();
            }
            for(int j=0; j<strSize; j++){
                if(strs[i].charAt(j) != strs[0].charAt(j)){ //비교하는 문자가 다르면 문자열 사이즈 변경 및 for문 중지
                    strSize = j;
                    break;
                }
            }
            if(strSize < 1){
                return "";
            }
        }
        return strs[0].substring(0,strSize);
    }
}
