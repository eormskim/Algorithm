package Leetcode;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); //["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("")); //[]
        System.out.println(letterCombinations("2")); //["a","b","c"]
    }

    public static List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(combinations, digits, digitToLetters, new StringBuilder(), 0);
        return combinations;
    }

    private static void backtrack(List<String> combinations, String digits, Map<Character, String> digitToLetters,
                                  StringBuilder current, int index) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(combinations, digits, digitToLetters, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
