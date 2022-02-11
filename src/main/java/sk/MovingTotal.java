package sk;

import java.util.ArrayList;
import java.util.List;

public class MovingTotal {
    private List<Integer> stack = new ArrayList<Integer>();
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
        for(int i : list){
            stack.add(i);
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     **/
    public boolean contains(int total) {
        boolean bool = false;
        int size = stack.size();
        if(size > 3){
            //1~3 더하고 4번째 갈떄 첫번쨰값 0으로 하고 다 더하기
            String val = "";
            for(int i=0; i<size; i++){
                val += stack.get(i) + "^";
                String[] nums = val.split("\\^");
                if(i != 0 && nums.length == 3){
                    int num = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) + Integer.parseInt(nums[2]);
                    if(num == total){
                        bool = true;
                        break;
                    }else{
                        String temp = nums[0]+"^";
                        val = val.replace(temp,"");
                    }
                }
            }
        }


        return bool;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }
}
