import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i < nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                int j = map.get(temp).intValue();
                if(i == j){
                    continue;
                }
                int[] result = {i,j};
                return result;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] rs = twoSum(nums,6);
        for(int i = 0;i < rs.length;i++){
            System.out.print(rs[i]);
        }
    }
}
