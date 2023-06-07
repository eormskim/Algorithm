package sixshop;

public class Solution1 {
    public static void main(String[] args){
        //식스샵 1번문제
        System.out.println(solution1("xyZA", "ABCxy"));
        System.out.println(solution1("AxA", "AyA"));
    }
    //식스샵 1번문제
    private static String solution1(String s1, String s2){

        int shortLen = s1.length() > s2.length() ? s2.length() : s1.length();

        int s1Top = -1;
        int s2Top = -1;

        for(int i=0; i<shortLen; i++){
            String s1Last = s1.substring((s1.length()-1)-i,s1.length()-1);
            String s2First = s2.substring(0,i);
            if(s1Last.equals(s2First)){
                s1Top = i;
            }

            String s1First = s1.substring(0,i);
            String s2Last = s2.substring((s2.length()-1)-i,s2.length()-1);
            if(s1First.equals(s2Last)){
                s2Top = i;
            }
        }

        String value = "";

        if(s1Top > s2Top && s1Top > -1){
            String s1First = s1.substring(0,s1.length()-s1Top-2);
            String seperator = s1.substring(s1.length() - s1Top -2, s1.length()-1);
            String s2Last = s2.substring(s1Top , s2.length());
            value = s1First + seperator + s2Last;
        }else if(s1Top < s2Top && s2Top >-1){
            String s2First = s2.substring(0, s2.length()-s2Top-2);
            String seperator = s2.substring(s2.length()-s2Top-2, s2.length() -1);
            String s1Last = s1.substring(s2Top , s1.length());
            value = s2First + seperator + s1Last;
        }else if(s1Top>-1 && s2Top>-1){
            String s1First = s1.substring(0,s1.length()-s1Top-2);
            String seperator1 = s1.substring(s1.length()-s1Top-2,s1.length()-1);
            String s2Last = s2.substring(s1Top,s2.length());
            String value1 = s1First + seperator1 +s2Last;

            String s2First = s2.substring(0,s2.length()-s2Top-2);
            String seperator2 = s2.substring(s2.length()-s2Top-2,s2.length()-1);
            String s1Last = s1.substring(s2Top,s1.length());
            String value2 = s2First + seperator2 + s1Last;
            value = value1.length() < value2.length() ? value2:value1;
        }else{
            value = s1 + s2;
        }

        return value;
    }
}
