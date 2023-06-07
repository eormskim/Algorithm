package programmers;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args){
        //완주하지 못한 선수
        String participant0[] = {"leo", "kiki", "eden"};
        String completion0[] = {"eden", "kiki"};
        System.out.println(solution1(participant0,completion0));

        String participant1[] = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String completion1[] = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution1(participant1,completion1));

        String participant2[] = {"mislav", "stanko", "mislav", "ana"};
        String completion2[] = {"stanko", "ana", "mislav"};
        System.out.println(solution1(participant2,completion2));
    }

    //프로그래머스 완주하지못한 선수
    private static String solution1(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant){
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        for(String name : completion){
            map.put(name, map.getOrDefault(name, 0)-1);
        }

        /*for(Map.Entry<String, Integer> keys : map.entrySet()){
            if(map.get(keys.getKey()) != 0){
                answer = keys.getKey();
            }
        }*/

        for(String keys : map.keySet()){
            if(map.get(keys) != 0){
                answer = keys;
            }
        }

        return answer;
    }
}
