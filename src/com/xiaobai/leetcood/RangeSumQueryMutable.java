package com.xiaobai.leetcood;

public class RangeSumQueryMutable {
    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int i, int val) {
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            int res = 0;
            for(int index = i;index <= j;index++){
                res += nums[index];
            }
            return res;
        }
    }
}
