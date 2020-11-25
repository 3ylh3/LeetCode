package com.xiaobai.leetcood;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author yin_zhj
 * @date 2020/4/14
 */
public class SearchinRotatedSortedArray {
    /**
     * 利用二分查找，首先确定出数组翻转的位置，然后再对应的区间进行二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0) {
            return -1;
        }
        int i = 0;
        for(;i < nums.length;i++) {
            if(i + 1 < nums.length && nums[i] > nums[i + 1]) {
                break;
            }
        }
        if(i == nums.length) {
            return binarySearch(target, nums, 0, nums.length - 1);
        }
        if(i == 0) {
            if(nums[0] == target) {
                return 0;
            } else {
                return binarySearch(target, nums, 1, nums.length - 1);
            }
        }
        if(target >= nums[0] && target <= nums[i]) {
            return binarySearch(target, nums, 0, i);
        } else if(target > nums[i] || target < nums[i + 1]) {
            return -1;
        } else {
            return binarySearch(target, nums, i + 1, nums.length - 1);
        }
    }
    public int binarySearch(int target, int[] nums, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return binarySearch(target, nums, start, mid - 1);
        } else {
            return binarySearch(target, nums, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        SearchinRotatedSortedArray searchinRotatedSortedArray = new SearchinRotatedSortedArray();
        System.out.println(searchinRotatedSortedArray.binarySearch(0, nums, 0, 1));
    }
}
