package com.testharness;

import java.util.Arrays;

public class Twosum {

    public static void main(String[] args) {
        Twosum tw = new Twosum();

        int[] intArray = {2,7,13,15};
        int[] result = tw.twoSum(intArray, 20);

        System.out.println(Arrays.toString(result));
    }

    // Two Sum
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[] { i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution found");
    }

}
