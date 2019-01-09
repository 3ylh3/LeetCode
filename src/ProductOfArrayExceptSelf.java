import java.util.Stack;

public class ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] r1 = new int[nums.length];
        int[] r2 = new int[nums.length];
        r1[0] = 1;
        r2[nums.length - 1] = 1;
        for(int i = 1;i < nums.length;i++){
            r1[i] = r1[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 2;i >= 0;i--){
            r2[i] = r2[i + 1] * nums[i + 1];
        }
        for(int i = 0;i < nums.length;i++){
            output[i] = r1[i] * r2[i];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        for(int i = 0;i < result.length;i++){
            System.out.println(result[i]);
        }
    }
}
