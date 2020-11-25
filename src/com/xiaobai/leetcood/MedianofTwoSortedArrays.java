package com.xiaobai.leetcood;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] tmp = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < length1 && j < length2) {
            if(nums1[i] < nums2[j]) {
                tmp[k] = nums1[i];
                i++;
            } else {
                tmp[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(i < length1) {
            //将num1剩下的内容复制到tmp中
            System.arraycopy(nums1, i, tmp, k, length1 - i);
        }
        if(j < length2) {
            //将num2剩下的内容复制到tmp中
            System.arraycopy(nums2, j, tmp, k, length2 - j);
        }
        if(((length1 + length2) % 2) != 0) {
            return tmp[(length1 + length2 - 1) / 2];
        } else {
            return (double) (tmp[(length1 + length2) / 2] + tmp[(length1 + length2) / 2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {3,4};
        MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
        System.out.println(medianofTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
