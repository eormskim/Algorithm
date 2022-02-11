package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        //프로그래머스 해시 전화번호 목록
        String[] phone_book1 = {"119", "97674223", "1195524421"};//false
        String[] phone_book2 = {"123","456","789"};	//true
        String[] phone_book3 = {"12","123","1235","567","88"}; //false
        System.out.println(solution2(phone_book1));
        System.out.println(solution2(phone_book2));
        System.out.println(solution2(phone_book3));
    }

    private static boolean solution2(String[] phone_book) {
        boolean answer = true;
    //["119", "97674223", "1195524421"]	false
        List<String> list = new ArrayList<String>(Arrays.asList(phone_book));
        int index = 0;
        for(String val : phone_book){
            if(list.size() < index+2){
                break;
            }
            if(list.get(index + 1).startsWith(val)){
                answer = false;
                break;
            }
            index++;
        }

        return answer;
    }
}