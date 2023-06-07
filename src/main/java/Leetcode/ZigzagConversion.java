package Leetcode;

public class ZigzagConversion {
    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 3)); //PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); //PINALSIGYAHRPI
        System.out.println(convert("A", 1)); //A
        System.out.println(convert("ABC", 1)); //ABC
        System.out.println(convert("ABCD", 2)); // ACBD
        System.out.println(convert("ABCDE", 2)); // ACBD
        System.out.println(convert("ABC", 2)); //ACB
        System.out.println(convert("PAYPALISHIRING", 11)); // PAYPALISGHNIIR
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 2)); // PAYPALISGHNIIR
    }

    static String convert(String s, int numRows){
        if(numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        int index = 0;
        int direction = -1;
        for(int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if(index == 0 || index == numRows - 1) {
                direction *= -1;
            }
            index += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            result.append(stringBuilder);
        }

        return result.toString();
    }
}