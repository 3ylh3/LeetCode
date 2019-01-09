class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        String s = Integer.toBinaryString(z);
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}
public class HammingDistance {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingDistance(1,4));
    }
}
