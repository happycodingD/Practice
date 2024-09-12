package Amazon;

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum_hm(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if(hm.containsKey(target-nums[i])) {
                return new int[] {hm.get(target-nums[i]), i};
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[] {};
    }

    public static int[] twoSum_bf(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]+nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        System.out.println("Output: " + Arrays.toString(twoSum_bf(nums, 9)));
    }
}
