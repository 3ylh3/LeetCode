/**
 * 495
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //总中毒时间
        int res = 0;
        //上次中毒截止时间点
        int endTime = 0;
        //遍历攻击时间点数组
        for(int i = 0;i < timeSeries.length;i++){
            //如果开始攻击时间点大于等于上次中毒截止时间点
            if(timeSeries[i] >= endTime){
                //总中毒时间加上单次中毒持续时间
                res += duration;
            }
            else{
                //总中毒时间加上单次中毒持续时间再减去本次攻击开始时间点和上次中毒截止时间点的时间差
                res += duration - (endTime - timeSeries[i]);
            }
            endTime = timeSeries[i] + duration;
        }
        return res;
    }
}
