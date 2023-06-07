package Leetcode;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *  Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        str = "bbbbb";
        System.out.println(lengthOfLongestSubstring(str));
        str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();
        int maximumLength = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++){
            if(seen.containsKey(s.charAt(end))){
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }
            seen.put(s.charAt(end), end);
            maximumLength = Math.max(maximumLength, end-start + 1);
        }

        return maximumLength;
    }
}
