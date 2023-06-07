package Leetcode;

import java.util.*;

public class MedianofTwoSortedArrays {
    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2})); //2.00000
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4})); //2.50000
        System.out.println(findMedianSortedArrays(new int[]{},new int[]{2,3})); //2.5
    }
    

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double rtnVal = 0;
        ArrayList<Integer> sumNums = new ArrayList<>();
        for (int j : nums1) {
            sumNums.add(j);
        }
        for (int j : nums2) {
            sumNums.add(j);
        }
        sumNums.sort(Integer::compareTo);

        int sumNumsSize = sumNums.size();
        int i=sumNumsSize/2;
            if(sumNumsSize > 2){
                if(sumNumsSize % 2 == 0){
                    rtnVal = (sumNums.get(i) + sumNums.get(i-1))/2.0;
                }else{
                    rtnVal = sumNums.get(i);
                }
            }else if(sumNumsSize == 2){
                rtnVal = (sumNums.get(i) + sumNums.get(i-1)) / 2.0;
            }else{
                rtnVal = sumNums.get(0);
            }

        System.out.println(sumNums);
        return rtnVal;
    }
}
