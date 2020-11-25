package com.xiaobai.leetcood;

/**
 * TODO
 *
 * @author yin_zhj
 * @date 2020/4/14
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] rs = {-1, -1};
        if(null == nums || nums.length == 0) {
            return rs;
        }
        int index = binarySearch(target, nums, 0, nums.length - 1);
        if(index == -1) {
            return rs;
        }
        int l = index;
        int r = index;
        int i = index - 1;
        int j = index + 1;
        rs[0] = index;
        rs[1] = index;
        while(-1 <= i) {
            int tmp = binarySearch(target, nums, 0, i);
            if(-1 == tmp) {
                rs[0] = l;
                break;
            } else {
                l = tmp;
                i--;
            }
        }
        while(j <= nums.length) {
            int tmp = binarySearch(target, nums, j, nums.length - 1);
            if(-1 == tmp) {
                rs[1] = r;
                break;
            } else {
                r = tmp;
                j++;
            }
        }
        return rs;
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
        FindFirstandLastPositionofElementinSortedArray f = new FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {1, 1, 2};
        int[] rs = f.searchRange(nums, 1);
        System.out.println(rs[0] + " " + rs[1]);
    }
}
