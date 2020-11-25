package com.xiaobai.leetcood;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    /**
     * 利用一个hashMap存储数组，key为数组值，value为对应下标，遍历数组，用结果减去当前数组值得到另一个值，拿这个值去
     * hashMap中查找下标，如果两个下标相同，则继续，不同则得到最后结果
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i < nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                int j = map.get(temp).intValue();
                if(i == j){
                    continue;
                }
                int[] result = {i,j};
                return result;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] rs = twoSum(nums,6);
        for(int i = 0;i < rs.length;i++){
            System.out.print(rs[i]);
        }
    }
}
