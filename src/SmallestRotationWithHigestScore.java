import java.util.*;

/*
798
超时
 */
public class SmallestRotationWithHigestScore {
    public int bestRotation(int[] A) {
        if (A == null) {
            return 0;
        }
        //记录最高分
        int maxScore = 0;
        //记录最高分对应的k值
        int maxK = 0;
        //记录临时分
        int tmpScore = 0;
        //记录交换位置后的索引
        int tmpIndex = 0;
        int length = A.length;
        for (int k = 0; k < length; k++) {
            int tmp = length - k;
            for (int i = 0; i < length; i++) {
                //对于数组的每一位，如果它索引i小于k，那么交换位置后它的索引变为i + length - k,否则变为i - k
                tmpIndex = i >= k ? i - k : i + tmp;
                //比较索引和值
                if (A[i] <= tmpIndex) {
                    tmpScore++;
                }
            }
            //比较临时分和最高分
            if (tmpScore > maxScore) {
                maxK = k;
                maxScore = tmpScore;
            }
        }
        return maxK;
    }
}
