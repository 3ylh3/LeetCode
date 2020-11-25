package com.xiaobai.leetcood;

import java.util.Arrays;

public class ArrayPartition1 {
    static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = nums.length - 2;i >= 0;i = i - 2){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
}
