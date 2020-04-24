/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * @author yin_zhj
 * @date 2020/4/24
 */
public class ReversePairs {
    /**
     * 超时。。。
     * @param nums
     * @return
     */
//    public int reversePairs(int[] nums) {
//        return pairs(nums, 0, nums.length);
//    }
//
//    public int pairs(int[] nums, int start, int end) {
//        if(null == nums || nums.length == 0) {
//            return 0;
//        }
//        if(start >= end) {
//            return 0;
//        }
//        int rs = 0;
//        int tmp = 0;
//        for(int i = start + 1;i < end;i++) {
//            if(nums[start] > nums[i]) {
//                tmp++;
//            }
//        }
//        return tmp + pairs(nums, start + 1, end);
//    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int start, int end) {
        if(start < end){
            int mid = (end + start) / 2;
            //递归对左右两个序列进行排序,然后合并两个序列
            return mergeSort(nums,start,mid) + mergeSort(nums,mid + 1,end) + merge(nums,start,mid,end);
        } else {
            return 0;
        }
    }

    public int merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int rs = 0;
        int k = 0;
        //遍历序列
        while(i <= mid && j <= end){
            if(nums[i] > nums[j]){
                //如果i位置大于j位置，则第一个序列i后所有的值均大于j位置,所以可以组成的逆序对数为mid - i + 1个
                rs += mid - i + 1;
                tmp[k] = nums[j];
                j++;
            } else {
                tmp[k] = nums[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp,0,nums,start,tmp.length);
        return rs;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[] {1,3,2,3,1}));
    }
}
