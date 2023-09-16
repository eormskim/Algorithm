package Leetcode;

import java.util.Arrays;

/** test
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); //49
        System.out.println(maxArea(new int[]{1,1})); //1
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6})); //17
        System.out.println(maxArea(new int[]{14,0,12,3,8,3,13,5,14,8})); //112
        System.out.println(maxArea(new int[]{10,9,8,7,6,5,4,3,2,1})); //25
    }
    static int maxArea(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
