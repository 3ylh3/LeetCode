import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * @author yin_zhj
 * @date 2020/4/21
 */
public class CountNumberofNiceSubarrays {
    /**
     * 超时。。。
     * @param nums
     * @param k
     * @return
     */
//    public int numberOfSubarrays(int[] nums, int k) {
//        int rs = 0;
//        if(nums.length < k) {
//            return 0;
//        }
//        if(nums.length == k) {
//            for(int i = 0;i < nums.length; i++) {
//                if(nums[i] % 2 == 0) {
//                    return 0;
//                }
//            }
//            rs++;
//        } else {
//            int sum = 0;
//            for(int i = k;i <= nums.length;i++) {
//                int tmp = 0;
//                for(int j = 0;j < i;j++) {
//                    if(nums[j] % 2 != 0) {
//                        tmp++;
//                        if(tmp > k) {
//                            break;
//                        }
//                    }
//                }
//                if(tmp == k) {
//                    sum++;
//                }
//            }
//
//            rs = rs + sum;
//            rs = rs + numberOfSubarrays(Arrays.copyOfRange(nums, 1, nums.length), k);
//        }
//        return rs;
//    }

    /**
     * 这个题目中偶数其实是没有用的，我们可以单独建立一个 \textit{odd}odd 数组来记录第 ii 个奇数的下标。那么我们可以枚举奇数，假设当前枚举到第 ii 个，那么 [\textit{odd}[i],\textit{odd}[i+k-1]][odd[i],odd[i+k−1]] 这个子数组就恰好包含 kk 个奇数。由于奇数和奇数间存在偶数，所以一定存在其他子数组 [l,r][l,r] 满足 [l,r][l,r] 包含 [\textit{odd}[i],\textit{odd}[i+k-1]][odd[i],odd[i+k−1]] 且 [l,r][l,r] 里的奇数个数为 kk 个，那么这个需要怎么统计呢？
     *
     * 由于我们已经记录了每个奇数的下标，所以我们知道对于第 ii 个奇数，它的前一个奇数的下标为 \textit{odd}[i-1]odd[i−1]，也就是说 (\textit{odd}[i-1],\textit{odd}[i])(odd[i−1],odd[i]) 间的数都为偶数。同理可得 (\textit{odd}[i+k-1],\textit{odd}[i+k])(odd[i+k−1],odd[i+k]) 间的数也都为偶数。那么我们可以得出满足 l\in (\textit{odd}[i-1],\textit{odd}[i]]l∈(odd[i−1],odd[i]] 且 r\in [\textit{odd}[i+k-1],\textit{odd}[i+k])r∈[odd[i+k−1],odd[i+k]) 条件的子数组 [l,r][l,r] 包含 [\textit{odd}[i],\textit{odd}[i+k-1]][odd[i],odd[i+k−1]] 且 [l,r][l,r] 里的奇数个数为 kk 个。因此对于第 ii 个奇数，它对答案的贡献为符合条件的 [l,r][l,r] 的个数，即：
     *
     * (\textit{odd}[i] - \textit{odd}[i - 1]) * (\textit{odd}[i + k] - \textit{odd}[i + k - 1])
     * (odd[i]−odd[i−1])∗(odd[i+k]−odd[i+k−1])
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/tong-ji-you-mei-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        int j = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] % 2 != 0) {
                tmp[j] = i;
                j++;
            }
        }
        int rs = 0;
        for(int i = 0;i < j;i++) {
            if(i + k - 1 >= j) {
                break;
            }
            int left = 0;
            int right = 0;
            if(i > 0) {
                left = tmp[i] - tmp[i - 1];
            } else {
                left = tmp[i] + 1;
            }
            if(i + k >= j) {
                right = nums.length - tmp[i + k - 1];
            } else {
                right = tmp[i + k] - tmp[i + k - 1];
            }
            rs = rs + left * right;
        }
        return rs;
    }

    public static void main(String[] args) {
        CountNumberofNiceSubarrays countNumberofNiceSubarrays = new CountNumberofNiceSubarrays();
        System.out.println(countNumberofNiceSubarrays.numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
