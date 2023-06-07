package Leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */
public class Sum3Closest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1)); //2
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1)); //0
        System.out.println(threeSumClosest(new int[]{800,-56,-525,950,637,303,-960,-965,-915,686,566,-169,188,-286,-800,-753,-191,-473,317,368,-9,168,-193,340,-337,-668,-185,-138,-96,-995,-179,-8,-557,-168,-299,-438,311,208,-558,-734,-841,90,-508,531,-58,-666,803,836,-470,329,481,170,105,404,-737,160,990,540,865,-881,458,-630,-708,7,-857,23,539,871,479,-422,472,533,987,-502,-794,607,113,-843,365,-311,811,-768,-13,-905,-141,-512,-60,-722,847,-718,348,-342,936,-443,121,687,582,834,781,396,622,401,446,-528,-322,-878,-951,690,497,-556,525,-222,718,181,-587,-613,-706,984,-851,981,-118,841,165,835,-973,-241,-334,-457,-880,454,-214,971,443,-450,427,-497,-166,-358,184,-375,197,-352,-215,-147,-622,-590,-301,-724,-798,-79,934,-809,-149,532,722,868,-419,-67,-180,720,-712,307,813,621,-262,-68,-64,-914,576,604,-950,814,210,951,314,-789,-276,-779,-728,-409,-480,-440,-61,948,466,789,736,994,-546,812,327,-713,630,-201,691,692,-733,-785,301,-136,153,-403,155,-146,753,158,-730,-206,-836,-174,271}, -5717)); //-2933
        System.out.println(threeSumClosest(new int[]{2,3,8,9,10}, 16)); //15
    }

    static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == target) {
                    return currentSum;
                }

                if (closestSum == target || Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
