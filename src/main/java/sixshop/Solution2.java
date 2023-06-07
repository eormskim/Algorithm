package sixshop;

public class Solution2 {
    public static void main(String[] args){
        //식스샵 2번문제
        int[] grade1 = {2,2,1}; //113
        for(int val : solution2(grade1)){
            System.out.print(val);
        }
        System.out.println("");
        int[] grade2 = {3,2,1,2}; //1242
        for(int val : solution2(grade2)){
            System.out.print(val);
        }
    }
    //식스샵 2번
    private static int[] solution2(int[] grade){
        // 2,2,1 -> 1,1,3
        // 3,2,1,2 -> 1,2,4,2
        int[] answer = new int[grade.length];
        int gradeLen = grade.length;

        int index = -1;

        for(int val : grade){
            index++;
            answer[index] = 1;
            for(int i=0; i<gradeLen; i++) {
                if (index != i) {
                    if (grade[index] < grade[i]) {
                        answer[index]++;
                    }
                }
            }
        }

        return answer;
    }
}
