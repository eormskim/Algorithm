package Leetcode;
/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-1534236469));
    }

    static int reverse(int x){
        StringBuffer sb = new StringBuffer(Long.toString(x));
        String strX = sb.reverse().toString();
        long strLong;
        if(strX.endsWith("-")){
            strLong = Long.parseLong(strX.substring(0, strX.length() - 1)) * -1;
            if(strLong < Integer.MIN_VALUE){ //최소값 넘으면 0 반환
                return 0;
            }
        }else{
            strLong = Long.parseLong(strX);
            if(strLong > Integer.MAX_VALUE){ //최대값 넘으면 0 반환
                return 0;
            }
        }
        return (int) strLong;
    }
}
