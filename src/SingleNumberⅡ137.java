import java.util.Arrays;

public class SingleNumberⅡ137 {
    public int singleNumber(int[] nums) {
        //记录结果
        int res = 0;
        //如果数组只有一个数，那么结果为该数
        if(nums.length == 1){
            res = nums[0];
        }
        else {
            //对数组进行排序
            Arrays.sort(nums);
            //如果排序后第一个数不等于第二个数，那么结果为第一个数
            if (nums[0] != nums[1]) {
                res = nums[0];
            } else if (nums[nums.length - 1] != nums[nums.length - 2]) {
                //如果最后一个数不等于前一个数，那么结果为最后一个数
                res = nums[nums.length - 1];
            } else {
                //遍历数组（从数组第二位开始到倒数第二位结束），如果该数既不等于前一个数又不等于后一个数，那么结果为该数
                for (int i = 1; i < nums.length - 1; i++) {
                    if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                        res = nums[i];
                        break;
                    }
                }
            }
        }
        return res;
    }
}
