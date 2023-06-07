package Leetcode;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        for(int i=0; i<sb.length()/2; i++){
            if(sb.toString().charAt(i) != sb.toString().charAt(sb.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}
