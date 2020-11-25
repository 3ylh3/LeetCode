package com.xiaobai.leetcood;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author yin_zhj
 * @date 2020/4/30
 */
public class TrappingRainWater {
    /**
     * 初始i指针指向第一个非零位置，j指针指向i下一个位置，遍历数组，如果j位置高度小于i位置，则将j入队列，否则计算i和j之间
     * 的能盛雨水的容量（计算方法为i位置的高度乘上ij之间的距离差，然后减去中间被占部分，中间被占部分的位置都存在队列中），然后
     * 清楚队列，i指向j，j指向i的下一个位置，遍历完后i指向的是最高的位置，把i后面的高度翻转得到新数组，新数组最后加进去
     * i的高度然后递归调用。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(null == height || 0 == height.length) {
            return 0;
        }
        int rs = 0;
        int i = 0;
        for(;i < height.length;i++) {
            if(height[i] != 0) {
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int j = i + 1;i < height.length && j < height.length;) {
            if(height[i] <= height[j]) {
                rs += (j - i - 1) * height[i];
                if(!list.isEmpty()) {
                    for(int tmp : list) {
                        rs -= height[tmp];
                    }
                    list.clear();
                }
                i = j;
                j = i + 1;
            } else {
                list.add(j);
                j++;
            }
        }
        if(!list.isEmpty()) {
            int[] array = new int[list.size() + 1];
            for(int index = 0;index < list.size();index++) {
                array[index] = height[list.get(list.size() - 1 - index)];
            }
            array[list.size()] = height[i];
            rs += trap(array);
        }
        return rs;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[] {4,2,3}));
    }
}
