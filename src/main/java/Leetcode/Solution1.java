package Leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15},9)); // 0,1
        System.out.println(twoSum(new int[]{3,2,4},6)); // 1,2
        System.out.println(twoSum(new int[]{3,3},6)); // 0,1
    }
        public static int[] twoSum(int[] nums, int target) {
            int[] answer = {};

            IntStream list = Arrays.stream(nums);

            Integer[] result = list.boxed().toArray(Integer[]::new);





            return answer;
        }

}
