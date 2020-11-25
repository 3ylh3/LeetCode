package com.xiaobai.leetcood;

public class MaxConsecutiveOnes {
    static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxNum = 0;
        int num = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
               num++;
               if(num >= maxNum){
                   maxNum = num;
               }
            }
            else{
                num = 0;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
