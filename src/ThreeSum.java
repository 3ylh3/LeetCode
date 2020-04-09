import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author yin_zhj
 * @date 2020/4/9
 */
public class ThreeSum {
    /**
     * 将数组排序，选取一个值（从数组第一位开始循环，注意判重），设置两个指针分别指向该值下一位和数组末尾，比较三者之和，
     * 如果三者之和等于0，则将三个数放入list中，将左指针向右移，右指针向左移，（注意判断数组值是否重复）;若三者之和小于0，
     * 则左指针右移，否则右指针左移
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        if(nums.length < 3 || null == nums) {
            return rs;
        }
        for(int tmp = 0;tmp < nums.length - 1;tmp++) {
            if(nums[tmp] > 0) {
                break;
            }
            //去重
            if(tmp > 0 && nums[tmp] == nums[tmp - 1]) {
                continue;
            }
            int left = tmp + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[tmp] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[tmp]);
                    list.add(nums[right]);
                    rs.add(list);
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[tmp] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> rs = threeSum.threeSum(nums);
        for(List<Integer> list : rs) {
            for(int num : list) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}
