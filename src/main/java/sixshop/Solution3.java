package sixshop;

public class Solution3 {
    public static void main(String[] args){
        //식스샵 3번
        System.out.println(solution3(15));
        System.out.println(solution3(7));
        System.out.println(solution3(1000000000));
    }
    //식스샵 3번
    //15->3  7->-1
    private static int solution3(int n){
        int answer = 0;
        int n3 = n%3;
        int n5 = n%5;
        if(n3 != 0 && n5 != 0){
            answer = -1;
        }else{
            if(n5 == 0){
                answer = n/5;
            }else if(n3 == 0){
                answer = n/3;
            }
        }

        return answer;
    }
}
