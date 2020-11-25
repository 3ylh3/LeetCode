package com.xiaobai.leetcood;

/**
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *  
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 * 你将 不能直接访问该山脉数组，必须通过 com.xiaobai.leetcood.MountainArray 接口来获取数据：
 *
 * com.xiaobai.leetcood.MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * com.xiaobai.leetcood.MountainArray.length() - 会返回该数组的长度
 *  
 *
 * 注意：
 *
 * 对 com.xiaobai.leetcood.MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 *
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 *
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 *  
 *
 * 提示：
 *
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 *
 * @author yin_zhj
 * @date 2020/4/29
 */
class MountainArray {
    private int[] array;
    public MountainArray(int[] array) {
        this.array = array;
    }
    public int get(int index) {
        return array[index];
    }
    public int length() {
        return array.length;
    }
}
public class FindinMountainArray {
    /**
     * 先用二分查找找到山脉数组的峰值，方法如下：取中间索引mid，比较mid处的值a和mid + 1处的值b，
     * 如果a > b，则峰值在[start, mid]中，如果a < b，则峰值在[mid + 1, end]中。找到峰值位置index后，
     * 首先用二分查找在[0, index]中寻找目标值，如果找到则返回索引，如果未找到，则用二分查找在[index + 1, length - 1]
     * 中寻找。
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(null == mountainArr || 0 == mountainArr.length()) {
            return -1;
        }
        int length = mountainArr.length();
        int index = binarySearchTop(mountainArr, 0, length - 1);
        int lIndex = binarySearch1(mountainArr, target, 0, index);
        if(-1 != lIndex) {
            return lIndex;
        }
        int rIndex = binarySearch2(mountainArr, target, index + 1, length - 1);
        return rIndex;
    }

    public int binarySearchTop(MountainArray mountainArray, int start, int end) {
        if(start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if(mountainArray.get(mid) > mountainArray.get(mid + 1)) {
            return binarySearchTop(mountainArray, start, mid);
        } else {
            return binarySearchTop(mountainArray, mid + 1, end);
        }
    }

    public int binarySearch1(MountainArray mountainArray, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int tmp = mountainArray.get(mid);
        if(tmp == target) {
            return mid;
        }
        if(tmp > target) {
            return binarySearch1(mountainArray, target, start, mid - 1);
        } else {
            return binarySearch1(mountainArray, target, mid + 1, end);
        }
    }

    public int binarySearch2(MountainArray mountainArray, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int tmp = mountainArray.get(mid);
        if(tmp == target) {
            return mid;
        }
        if(tmp < target) {
            return binarySearch2(mountainArray, target, start, mid - 1);
        } else {
            return binarySearch2(mountainArray, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        FindinMountainArray findinMountainArray = new FindinMountainArray();
        System.out.println(findinMountainArray.findInMountainArray(1, new MountainArray(new int[] {0,5,3,1})));
    }
}
