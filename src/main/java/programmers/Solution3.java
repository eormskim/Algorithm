package programmers;

import java.util.Arrays;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.reducing;

public class Solution3 {
    public static void main(String[] args) {
        //프로그래머스 해시 위장
        String[][] clothes1 = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}}; //5
        String[][] clothes2 = {{"crow_mask","face"},{"blue_sunglasses","face"},{"smoky_makeup","face"}}; //3
        String[][] clothes3 ={{"crow_mask", "a"}, {"blue_sunglasses", "a"},{"smoky_makeup", "face"},{"crow_mask2", "face"},{"blue_sunglasses2", "c"},{"smoky_makeup2", "c"}};
        System.out.println(solution3(clothes1));
        System.out.println(solution3(clothes2));
        System.out.println(solution3(clothes3));
    }

    //프로그래머스 해시 위장
    private static int solution3(String[][] clothes){
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}