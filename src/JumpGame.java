import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author yin_zhj
 * @date 2020/4/17
 */
public class JumpGame {
    /**
     * 超时。。。
     * 递归，循环当前位置可以跳的步数，如果正好可以跳到末尾，则返回true，否则递归判断跳到这个位置后是否可以跳到末尾
     * @param nums
     * @return
     */
//    public boolean canJump(int[] nums) {
//        if(null == nums || nums.length == 0) {
//            return true;
//        }
//        if(nums.length == 1) {
//            return true;
//        }
//        boolean rs = jump(nums, 0);
//        return rs;
//    }
//
//    public boolean jump(int[] nums, int index) {
//        boolean rs = false;
//        for(int j = 1;j <= nums[index];j++) {
//            if(index + j == nums.length - 1) {
//                return true;
//            } else {
//                rs = jump(nums, index + j);
//                if(rs) {
//                    return true;
//                }
//            }
//        }
//        return rs;
//    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0;i < nums.length;i++) {
            if(max >= i) {
                max = Math.max(max, i + nums[i]);
                if(max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[] {3,2,1,0,4}));
    }
}
